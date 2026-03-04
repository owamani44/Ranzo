package com.chanzo.weightrecordservice.service;

import com.chanzo.weightrecordservice.dtos.WeightRequestDTO;
import com.chanzo.weightrecordservice.dtos.WeightResponseDTO;
import com.chanzo.weightrecordservice.exceptions.AnimalNotFound;
import com.chanzo.weightrecordservice.exceptions.TagNumberAlreadyExists;
import com.chanzo.weightrecordservice.mapper.WeightMapper;
import com.chanzo.weightrecordservice.model.Weight;
import com.chanzo.weightrecordservice.repo.WeightRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class WeightService {

    private  final WeightRepo weightRepo;

    public Double AverageDailyGain(Double incomingWeight, Double previousWeight, Weight existingRecord) {

        if (incomingWeight == null || previousWeight == null) {
            return null;
        }

        LocalDate lastMeasuredOn = existingRecord.getLastMeasuredOn();
        if (lastMeasuredOn == null) {
            return null;
        }

        long daysBetween = ChronoUnit.DAYS.between(lastMeasuredOn, LocalDate.now());
        if (daysBetween <= 0) {
            return null;
        }

        double weightDifference = incomingWeight - previousWeight;
        System.out.println("Weight Difference: " + weightDifference);
        System.out.println("Days Between: " + daysBetween);
        return weightDifference / daysBetween;
    }
    public Double averageWeight(){
        double totalWeight = weightRepo.getTotalWeight();
        long noOfAnimals = weightRepo.count();
        return  totalWeight / noOfAnimals;
    }

    public WeightResponseDTO recordWeight(WeightRequestDTO weightRequestDTO){
        if(weightRepo.existsByTagNumber(weightRequestDTO.getTagNumber()))
            throw new TagNumberAlreadyExists("An animal with the same tag number already exists"
                    + weightRequestDTO.getTagNumber());

        Weight newWeight = weightRepo.save(WeightMapper.toModel(weightRequestDTO));
        return WeightMapper.toDTO(newWeight);
    }

    public List<WeightResponseDTO> getAllWeightRecords(){
        List<Weight> weights = weightRepo.findAll();
        return weights.stream().map(WeightMapper::toDTO).toList();
    }

    public WeightResponseDTO getWeightRecordByTagNumber(String tagNumber){
        Weight weight = weightRepo.findByTagNumber(tagNumber).orElseThrow(
                ()->new AnimalNotFound("Animal not found: "+ tagNumber));

        return WeightMapper.toDTO(weight);
    }

    public WeightResponseDTO updateWeightRecord(Integer weightId, WeightRequestDTO weightRequestDTO){
       Weight newWeight = weightRepo.findById(weightId).
               orElseThrow(()-> new AnimalNotFound("Animal not found: "+ weightId));

       double previousWeight = newWeight.getWeight();
       double incomingWeight = weightRequestDTO.getWeight();
       if (previousWeight != 0.0 && incomingWeight != 0.0 && incomingWeight < previousWeight) {
           newWeight.setMedicalFollowUpRequired(true);
       }
       newWeight.setWeight(incomingWeight);
       double adg = AverageDailyGain(incomingWeight, previousWeight, newWeight);
        newWeight.setAverageDailyGain(adg);
       Weight updatedWeight = weightRepo.save(newWeight);
       return WeightMapper.toDTO(updatedWeight);
    }

    public void deleteWeightRecord(Integer weightId){
        weightRepo.deleteById(weightId);
    }
}
