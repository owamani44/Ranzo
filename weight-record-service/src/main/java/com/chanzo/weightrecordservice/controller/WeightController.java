package com.chanzo.weightrecordservice.controller;

import com.chanzo.weightrecordservice.dtos.WeightRequestDTO;
import com.chanzo.weightrecordservice.dtos.WeightResponseDTO;
import com.chanzo.weightrecordservice.service.WeightService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/weight")
@AllArgsConstructor
public class WeightController {
    private final WeightService weightService;
    @GetMapping("/mean-weight")
    public ResponseEntity<Double> getAverageWeight(){
        double meanWeight = weightService.averageWeight();
        return ResponseEntity.ok().body(meanWeight);
    }

    @Operation(summary = "Record a new weight entry for an animal")
    @PostMapping
    public ResponseEntity<WeightResponseDTO> recordWeight
            (@Valid @RequestBody WeightRequestDTO weightRequestDTO){
        WeightResponseDTO weightResponseDTO = weightService.recordWeight(weightRequestDTO);
        return ResponseEntity.ok().body(weightResponseDTO);
    }
    @Operation(summary = "Get the latest weight record for an animal by its tag number")
    @GetMapping("/by-tag/{tagNumber}")
    public ResponseEntity<WeightResponseDTO> getWeightRecord(@PathVariable String tagNumber){

        WeightResponseDTO dto = weightService.getWeightRecordByTagNumber(tagNumber);
        return  ResponseEntity.ok().body(dto);
    }
    @Operation(summary = "Get all weight records for all animals")
    @GetMapping("/all-weight-records")
    public ResponseEntity<List<WeightResponseDTO>> getAllWeightRecords(){
        List<WeightResponseDTO> weights = weightService.getAllWeightRecords();
        return ResponseEntity.ok().body(weights);
    }

    @Operation(summary = "Update an existing weight record ")
    @PatchMapping("/{weightId}")
    public ResponseEntity<WeightResponseDTO> updateWeightRecord
            (@PathVariable Integer weightId, @Validated({Default.class})
            @RequestBody WeightRequestDTO weightRequestDTO ){
        WeightResponseDTO upDTO = weightService.updateWeightRecord(weightId, weightRequestDTO);
        return ResponseEntity.ok().body(upDTO);
    }
    @Operation(summary = "Delete a weight record")
    @DeleteMapping("/{weightId}")
    public ResponseEntity<WeightResponseDTO> deleteWeightRecord(@PathVariable Integer weightId){
        weightService.deleteWeightRecord(weightId);
        return ResponseEntity.noContent().build();
    }

}
