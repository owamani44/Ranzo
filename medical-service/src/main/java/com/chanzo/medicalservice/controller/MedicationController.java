package com.chanzo.medicalservice.controller;

import com.chanzo.medicalservice.dtos.MedicationRequestDTO;
import com.chanzo.medicalservice.dtos.MedicationResponseDTO;
import com.chanzo.medicalservice.service.MedicationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medication")
@AllArgsConstructor
public class MedicationController {

    private final MedicationService medicationService;

    @PostMapping
    public ResponseEntity<MedicationResponseDTO> createMedication(@RequestBody MedicationRequestDTO
                                                                              medicalRequestDTO){
        MedicationResponseDTO dto = medicationService.createAction(medicalRequestDTO);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/{medicalID}")
    public ResponseEntity<MedicationResponseDTO> getMedicationById(@PathVariable Integer medicalID){
        MedicationResponseDTO dto1 = medicationService.getActionById(medicalID);
        return ResponseEntity.ok().body(dto1);
    }
    @GetMapping("/by-tag/{tagNumber}")
    public ResponseEntity<MedicationResponseDTO> getMedicationByTagNumber(@PathVariable String tagNumber){
        MedicationResponseDTO dto2 = medicationService.getMedicationByTagNumber(tagNumber);
        return ResponseEntity.ok().body(dto2);
    }

    @DeleteMapping("/{medicalID}")
    public ResponseEntity<MedicationResponseDTO> deleteMedicationById(@PathVariable Integer medicalID){
        medicationService.deleteAction(medicalID);
        return ResponseEntity.noContent().build();
    }
}
