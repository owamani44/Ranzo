package com.chanzo.medicalservice.controller;

import com.chanzo.medicalservice.dtos.HealthEventRequestDTO;
import com.chanzo.medicalservice.dtos.HealthEventResponseDTO;
import com.chanzo.medicalservice.service.HealthEventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/health-events")
public class HealthEventController {

    private final HealthEventService healthEventService;

    @GetMapping
    public ResponseEntity<List<HealthEventResponseDTO>> getAllHealthEvents() {
        List<HealthEventResponseDTO> healthEventResponseDTOS= healthEventService.getEvent();
        return ResponseEntity.ok().body(healthEventResponseDTOS);
    }

    @PostMapping
    public ResponseEntity<HealthEventResponseDTO>
    createHealthEvent(@RequestBody HealthEventRequestDTO healthEventRequestDTO) {
        HealthEventResponseDTO healthEventResponseDTO= healthEventService.
                createEvent(healthEventRequestDTO);
        return ResponseEntity.ok().body(healthEventResponseDTO);
    }

    @GetMapping("/{eventID}")
    public ResponseEntity<HealthEventResponseDTO> getEventById(@PathVariable Integer eventID){
        HealthEventResponseDTO healthEventResponseDTO = healthEventService.getEventById(eventID);
        return ResponseEntity.ok().body(healthEventResponseDTO);
    }

    @GetMapping("/by-tag/{tagNumber}")
    public ResponseEntity<HealthEventResponseDTO> getEventByTagNumber(@PathVariable String tagNumber){
        HealthEventResponseDTO healthEventResponseDTO= healthEventService.getEventByTagNumber(tagNumber);
        return ResponseEntity.ok().body(healthEventResponseDTO);
    }


}
