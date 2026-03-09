package com.chanzo.ranzo.medical.dtos;

import com.chanzo.ranzo.medical.model.EventType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class HealthEventResponseDTO {
    private Integer eventID;
    private  String tagNumber;
    private EventType eventType;
    private String symptoms;
    private String recordedBy;
    private LocalDateTime observedDate= LocalDateTime.now();
}
