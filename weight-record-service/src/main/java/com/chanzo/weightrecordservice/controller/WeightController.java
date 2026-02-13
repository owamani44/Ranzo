package com.chanzo.weightrecordservice.controller;

import com.chanzo.weightrecordservice.dtos.WeightRequestDTO;
import com.chanzo.weightrecordservice.dtos.WeightResponseDTO;
import com.chanzo.weightrecordservice.service.WeightService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weight")
@AllArgsConstructor
public class WeightController {
    private final WeightService weightService;

    @PostMapping
    public ResponseEntity<WeightResponseDTO> recordWeight
            (@Valid @RequestBody WeightRequestDTO weightRequestDTO){
        WeightResponseDTO weightResponseDTO = weightService.recordWeight(weightRequestDTO);
        return ResponseEntity.ok().body(weightResponseDTO);
    }

    @GetMapping("/by-tag/{tagNumber}")
    public ResponseEntity<WeightResponseDTO> getWeightRecord(@PathVariable String tagNumber){

        WeightResponseDTO dto = weightService.getWeightRecordByTagNumber(tagNumber);
        return  ResponseEntity.ok().body(dto);
    }

    @GetMapping("/all-weight-records")
    public ResponseEntity<List<WeightResponseDTO>> getAllWeightRecords(){
        List<WeightResponseDTO> weights = weightService.getAllWeightRecords();
        return ResponseEntity.ok().body(weights);
    }

    @PatchMapping("/{weightId}")
    public ResponseEntity<WeightResponseDTO> updateWeightRecord
            (@PathVariable Integer weightId, @Validated({Default.class})
            @RequestBody WeightRequestDTO weightRequestDTO ){
        WeightResponseDTO upDTO = weightService.updateWeightRecord(weightId, weightRequestDTO);
        return ResponseEntity.ok().body(upDTO);
    }
    @DeleteMapping("/{weightId}")
    public ResponseEntity<WeightResponseDTO> deleteWeightRecord(@PathVariable Integer weightId){
        weightService.deleteWeightRecord(weightId);
        return ResponseEntity.noContent().build();
    }

}
