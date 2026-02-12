package com.chanzo.weightrecordservice.mapper;

import com.chanzo.weightrecordservice.dtos.WeightRequestDTO;
import com.chanzo.weightrecordservice.dtos.WeightResponseDTO;
import com.chanzo.weightrecordservice.model.Weight;

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
