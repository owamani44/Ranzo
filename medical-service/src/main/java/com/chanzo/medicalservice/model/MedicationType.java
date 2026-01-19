package com.chanzo.medicalservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Authour: Solomon Owamani
 * */
@AllArgsConstructor
@Getter
public enum MedicationType {
    MEDICATION("Medication"),
    PROCEDURE("Procedure"),
    VACCINATION("Vaccination"),
    OTHER("Other");

    private final String displayMedicationType;
}
