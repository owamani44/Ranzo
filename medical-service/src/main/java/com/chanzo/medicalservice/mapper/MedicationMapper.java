package com.chanzo.medicalservice.mapper;

import com.chanzo.medicalservice.dtos.MedicationResponseDTO;
import com.chanzo.medicalservice.dtos.MedicationRequestDTO;
import com.chanzo.medicalservice.model.Medication;

public class MedicationMapper {
    public static MedicationResponseDTO toDTO(Medication medication) {
        MedicationResponseDTO dto= new MedicationResponseDTO();
        dto.setMedicalID(medication.getMedicalID());
        dto.setType(medication.getType());
        dto.setDrugName(medication.getDrugName());
        dto.setDosage(medication.getDosage());
        dto.setAdministeredBy(medication.getAdministeredBy());
        dto.setAdministeredAt(medication.getAdministeredAt());

        return dto;
    }

    public static Medication toModel (MedicationRequestDTO medicationRequestDTO){
        Medication action = new Medication();
        action.setType(medicationRequestDTO.getType());
        action.setDrugName(medicationRequestDTO.getDrugName());
        action.setDosage(medicationRequestDTO.getDosage());
        action.setAdministeredBy(medicationRequestDTO.getAdministeredBy());
        action.setAdministeredAt(medicationRequestDTO.getAdministeredAt());

        return action;
    }
}
