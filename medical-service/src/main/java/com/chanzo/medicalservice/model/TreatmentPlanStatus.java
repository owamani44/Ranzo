package com.chanzo.medicalservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter

@AllArgsConstructor

public enum TreatmentPlanStatus {

    ACTIVE("Active"),
    COMPLETED("Completed"),
    CANCELED("Canceled");

    private final String displayStatus;

}
