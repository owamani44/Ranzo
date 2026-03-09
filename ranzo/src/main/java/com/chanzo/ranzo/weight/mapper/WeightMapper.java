package com.chanzo.ranzo.weight.mapper;


import com.chanzo.ranzo.weight.dtos.WeightRequestDTO;
import com.chanzo.ranzo.weight.dtos.WeightResponseDTO;
import com.chanzo.ranzo.weight.model.Weight;

public class WeightMapper {
    public static WeightResponseDTO toDTO(Weight weight) {
        WeightResponseDTO dto = new WeightResponseDTO();
        dto.setWeightId(weight.getWeightId().longValue());
        dto.setTagNumber(weight.getTagNumber());
        dto.setWeight(weight.getWeight());
        dto.setAverageDailyGain(weight.getAverageDailyGain());
        dto.setMedicalFollowUpRequired(weight.isMedicalFollowUpRequired());
        dto.setFirstMeasuredOn(weight.getFirstMeasuredOn());
        dto.setLastMeasuredOn(weight.getLastMeasuredOn());

        return dto;
    }

    public static Weight toModel(WeightRequestDTO weightRequestDTO) {
        Weight weight = new Weight();
        weight.setTagNumber(weightRequestDTO.getTagNumber());
        weight.setWeight(weightRequestDTO.getWeight());
        weightRequestDTO.setMedicalFollowUpRequired(false);

        return weight;
    }
}
