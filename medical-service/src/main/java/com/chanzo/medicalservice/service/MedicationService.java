package com.chanzo.medicalservice.service;

import com.chanzo.medicalservice.dtos.MedicationResponseDTO;
import com.chanzo.medicalservice.dtos.MedicationRequestDTO;
import com.chanzo.medicalservice.mapper.MedicationMapper;
import com.chanzo.medicalservice.model.Medication;
import com.chanzo.medicalservice.repo.MedicationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicationService {
    private final MedicationRepo medicationRepo;

    public MedicationResponseDTO createAction(MedicationRequestDTO medicationRequestDTO) {
        Medication newAction= medicationRepo.save
                (MedicationMapper.toModel(medicationRequestDTO));
        return MedicationMapper.toDTO(newAction);
    }
    public MedicationResponseDTO getActionById(Integer MedicalID){
        Medication action = medicationRepo.findById(MedicalID).
                orElseThrow(()-> new IllegalArgumentException("Medical Action not found"));
        return MedicationMapper.toDTO(action);
    }
    public void deleteAction(Integer medicalID){
        medicationRepo.deleteById(medicalID);
    }
}
