package com.chanzo.ranzo.medical.mapper;

import com.chanzo.ranzo.medical.dtos.HealthEventRequestDTO;
import com.chanzo.ranzo.medical.dtos.HealthEventResponseDTO;
import com.chanzo.ranzo.medical.model.HealthEvent;

public class HealthEventMapper {
    public static HealthEventResponseDTO  toDTO(HealthEvent healthEvent){
        HealthEventResponseDTO healthEventResponseDTO = new HealthEventResponseDTO();
        healthEventResponseDTO.setEventID(healthEvent.getEventID());
        healthEventResponseDTO.setTagNumber(healthEvent.getTagNumber());
        healthEventResponseDTO.setEventType(healthEvent.getEventType());
        healthEventResponseDTO.setSymptoms(healthEvent.getSymptoms());
        healthEventResponseDTO.setRecordedBy(healthEvent.getRecordedBy());
        healthEventResponseDTO.setObservedDate(healthEvent.getObservedDate());

        return healthEventResponseDTO;
    }
    public static HealthEvent toModel(HealthEventRequestDTO healthEventRequestDTO){
        HealthEvent healthEvent1 = new HealthEvent();
        healthEvent1.setTagNumber(healthEventRequestDTO.getTagNumber());
        healthEvent1.setEventType(healthEventRequestDTO.getEventType());
        healthEvent1.setSymptoms(healthEventRequestDTO.getSymptoms());
        healthEvent1.setRecordedBy(healthEventRequestDTO.getRecordedBy());


        return healthEvent1;
    }
}
