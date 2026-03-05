package com.chanzo.medicalservice.dtos;

import com.chanzo.medicalservice.model.MedicationStatus;
import com.chanzo.medicalservice.model.MedicationType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class MedicationRequestDTO {
    @NotBlank
    private MedicationType type;
    @NotBlank
    private MedicationStatus status;
    @NotBlank
    private String tagNumber;
    @NotBlank
    private String drugName;
    @NotBlank
    private String dosage;
    @NotBlank
    private String administeredBy;

}
