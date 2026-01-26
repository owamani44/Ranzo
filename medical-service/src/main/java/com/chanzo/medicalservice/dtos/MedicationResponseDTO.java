package com.chanzo.medicalservice.dtos;

import com.chanzo.medicalservice.model.MedicationType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class MedicationResponseDTO {
    private Integer medicalID;
    private MedicationType type;
    private String drugName;
    private String dosage;
    private String administeredBy;
    private LocalDateTime administeredAt=LocalDateTime.now();

}
