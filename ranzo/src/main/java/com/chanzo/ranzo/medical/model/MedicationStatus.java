package com.chanzo.ranzo.medical.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MedicationStatus {
    ACTIVE("Active"),
    COMPLETED("Completed");

    private final String displayMedicationStatus;
}
