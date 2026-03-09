package com.chanzo.ranzo.medical.controller;


import com.chanzo.ranzo.medical.dtos.MedicationRequestDTO;
import com.chanzo.ranzo.medical.dtos.MedicationResponseDTO;
import com.chanzo.ranzo.medical.service.MedicationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;





@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/medication")
@AllArgsConstructor
public class MedicationController {

    private final MedicationService medicationService;

    @Operation(summary="Get the count of sick animals")
    @GetMapping("/sick-count")
    public ResponseEntity<Integer> getSickAnimalsCount(){
        int count = medicationService.getSickAnimalsCount();
        return ResponseEntity.ok().body(count);
    }

    @Operation(summary = "Create a new medication record")
    @PostMapping
    public ResponseEntity<MedicationResponseDTO> createMedication(@RequestBody MedicationRequestDTO
                                                                              medicalRequestDTO){
        MedicationResponseDTO dto = medicationService.createAction(medicalRequestDTO);
        return ResponseEntity.ok().body(dto);
    }

    @Operation(summary = "Get a medication record by ID ")
    @GetMapping("/{medicalID}")
    public ResponseEntity<MedicationResponseDTO>  MedicationById(@PathVariable Integer medicalID){
        MedicationResponseDTO dto1 = medicationService.getActionById(medicalID);
        return ResponseEntity.ok().body(dto1);
    }

    @Operation(summary = "Get medication record by tag number")
    @GetMapping("/by-tag/{tagNumber}")
    public ResponseEntity<MedicationResponseDTO> getMedicationByTagNumber(@PathVariable String tagNumber){
        MedicationResponseDTO dto2 = medicationService.getMedicationByTagNumber(tagNumber);
        return ResponseEntity.ok().body(dto2);
    }

    @Operation(summary = "Delete a medication record")
    @DeleteMapping("/{medicalID}")
    public ResponseEntity<MedicationResponseDTO> deleteMedicationById(@PathVariable Integer medicalID){
        medicationService.deleteAction(medicalID);
        return ResponseEntity.noContent().build();
    }
}
