package com.chanzo.ranzo.medical.mapper;


import com.chanzo.ranzo.medical.dtos.MedicationRequestDTO;
import com.chanzo.ranzo.medical.dtos.MedicationResponseDTO;
import com.chanzo.ranzo.medical.model.Medication;

public class MedicationMapper {
    public static MedicationResponseDTO toDTO(Medication medication) {
        MedicationResponseDTO dto= new MedicationResponseDTO();
        dto.setMedicalID(medication.getMedicalID());
        dto.setTagNumber(medication.getTagNumber());
        dto.setType(medication.getType());
        dto.setStatus(medication.getStatus());
        dto.setDrugName(medication.getDrugName());
        dto.setDosage(medication.getDosage());
        dto.setAdministeredBy(medication.getAdministeredBy());
        dto.setAdministeredAt(medication.getAdministeredAt());

        return dto;
    }

    public static Medication toModel (MedicationRequestDTO medicationRequestDTO){
        Medication action = new Medication();
        action.setTagNumber(medicationRequestDTO.getTagNumber());
        action.setType(medicationRequestDTO.getType());
        action.setStatus(medicationRequestDTO.getStatus());
        action.setDrugName(medicationRequestDTO.getDrugName());
        action.setDosage(medicationRequestDTO.getDosage());
        action.setAdministeredBy(medicationRequestDTO.getAdministeredBy());


        return action;
    }
}
