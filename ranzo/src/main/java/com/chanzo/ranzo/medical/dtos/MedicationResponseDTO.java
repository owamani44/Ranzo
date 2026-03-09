package com.chanzo.ranzo.medical.dtos;

import com.chanzo.ranzo.medical.model.MedicationStatus;
import com.chanzo.ranzo.medical.model.MedicationType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class MedicationResponseDTO {
    private Integer medicalID;
    private String tagNumber;
    private MedicationType type;
    private MedicationStatus status;
    private String drugName;
    private String dosage;
    private String administeredBy;
    private LocalDateTime administeredAt=LocalDateTime.now();

}
