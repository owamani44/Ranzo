package com.chanzo.ranzo.medical.controller;


import com.chanzo.ranzo.medical.dtos.HealthEventRequestDTO;
import com.chanzo.ranzo.medical.dtos.HealthEventResponseDTO;
import com.chanzo.ranzo.medical.service.HealthEventService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("/health-events")
public class HealthEventController {

    private final HealthEventService healthEventService;
    @Operation(summary = "Get all health events", description = "Retrieve a list of all health events recorded in the system.")
    @GetMapping
    public ResponseEntity<List<HealthEventResponseDTO>> getAllHealthEvents() {
        List<HealthEventResponseDTO> healthEventResponseDTOS= healthEventService.getEvent();
        return ResponseEntity.ok().body(healthEventResponseDTOS);
    }

    @Operation(summary = "Record a new health event", description = "Record a new health event for an animal," +
            " including details such as the type of event, date, and any relevant notes.")
    @PostMapping
    public ResponseEntity<HealthEventResponseDTO>
    createHealthEvent(@RequestBody HealthEventRequestDTO healthEventRequestDTO) {
        HealthEventResponseDTO healthEventResponseDTO= healthEventService.
                createEvent(healthEventRequestDTO);
        return ResponseEntity.ok().body(healthEventResponseDTO);
    }

    @Operation(summary = "Get health event")
    @GetMapping("/{eventID}")
    public ResponseEntity<HealthEventResponseDTO> getEventById(@PathVariable Integer eventID){
        HealthEventResponseDTO healthEventResponseDTO = healthEventService.getEventById(eventID);
        return ResponseEntity.ok().body(healthEventResponseDTO);
    }

    @Operation(summary="Get event by tag number")
    @GetMapping("/by-tag/{tagNumber}")
    public ResponseEntity<HealthEventResponseDTO> getEventByTagNumber(@PathVariable String tagNumber){
        HealthEventResponseDTO healthEventResponseDTO= healthEventService.getEventByTagNumber(tagNumber);
        return ResponseEntity.ok().body(healthEventResponseDTO);
    }
    @Operation(summary ="Delete health event from system")
    @DeleteMapping("/{eventID}")
    public ResponseEntity<HealthEventResponseDTO> deleteEventById(@PathVariable Integer eventID){
        healthEventService.deleteEvent(eventID);
        return ResponseEntity.noContent().build();
    }

}
