package com.chanzo.ranzo.medical.model;

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
    VACCINATION("Vaccination");


    private final String displayMedicationType;
}
