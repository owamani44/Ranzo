package com.chanzo.ranzo.medical.dtos;

import com.chanzo.ranzo.medical.model.MedicationStatus;
import com.chanzo.ranzo.medical.model.MedicationType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

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
