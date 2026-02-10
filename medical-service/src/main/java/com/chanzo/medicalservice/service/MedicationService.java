package com.chanzo.medicalservice.service;

import com.chanzo.medicalservice.dtos.MedicationResponseDTO;
import com.chanzo.medicalservice.dtos.MedicationRequestDTO;
import com.chanzo.medicalservice.exceptions.AnimalNotFound;
import com.chanzo.medicalservice.mapper.MedicationMapper;
import com.chanzo.medicalservice.model.Medication;
import com.chanzo.medicalservice.model.MedicationStatus;
import com.chanzo.medicalservice.repo.MedicationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicationService {
    private final MedicationRepo medicationRepo;

    public int getSickAnimalsCount(){
        return medicationRepo.countByStatus(MedicationStatus.ACTIVE);
    }

    public MedicationResponseDTO createAction(MedicationRequestDTO medicationRequestDTO) {
        Medication newAction= medicationRepo.save
                (MedicationMapper.toModel(medicationRequestDTO));
        return MedicationMapper.toDTO(newAction);
    }
    public MedicationResponseDTO getActionById(Integer MedicalID){
        Medication action = medicationRepo.findById(MedicalID).
                orElseThrow(()-> new IllegalArgumentException("Medical Action not found"));
        return MedicationMapper.toDTO(action);
    }
    public MedicationResponseDTO getMedicationByTagNumber(String tagNumber){
        Medication medication1= medicationRepo.findByTagNumber(tagNumber).
                orElseThrow(()-> new AnimalNotFound("Animal with this tag number can not be found: "+ tagNumber));
        return MedicationMapper.toDTO(medication1);
    }
    public void deleteAction(Integer medicalID){
        medicationRepo.deleteById(medicalID);
    }
}
