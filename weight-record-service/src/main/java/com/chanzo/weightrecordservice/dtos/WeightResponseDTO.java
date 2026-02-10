package com.chanzo.weightrecordservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
public class WeightResponseDTO {
    private Long weightId;
    private String tagNumber;
    private Long weight;
    private boolean medicalFollowUpRequired;
    private LocalDate firstMeasuredOn;
    private LocalDate lastMeasuredOn;
}
