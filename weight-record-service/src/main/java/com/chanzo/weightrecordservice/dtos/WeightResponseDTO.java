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
    private Double weight;
    private  Double averageDailyGain;
    private boolean medicalFollowUpRequired;
    private LocalDate firstMeasuredOn;
    private LocalDate lastMeasuredOn;
}
