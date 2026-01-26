package com.chanzo.medicalservice.service;

import com.chanzo.medicalservice.dtos.HealthEventRequestDTO;
import com.chanzo.medicalservice.dtos.HealthEventResponseDTO;
import com.chanzo.medicalservice.mapper.HealthEventMapper;
import com.chanzo.medicalservice.model.HealthEvent;
import com.chanzo.medicalservice.repo.HealthEventRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HealthEventService {

    private final HealthEventRepo healthEventRepo;

    public List<HealthEventResponseDTO> getEvent(){
        List<HealthEvent> healthEvents =healthEventRepo.findAll();
        return healthEvents.stream().map(HealthEventMapper::toDTO).toList();
    }

    public HealthEventResponseDTO createEvent(HealthEventRequestDTO
                                                      healthEventRequestDTO){
        HealthEvent newHealthEvent = healthEventRepo.save(HealthEventMapper.
                toModel(healthEventRequestDTO));
        return HealthEventMapper.toDTO(newHealthEvent);
    }

    public HealthEventResponseDTO getEventById(Integer eventID){
        HealthEvent event = healthEventRepo.findById(eventID).
                orElseThrow(()-> new IllegalArgumentException("Event not found"));

        return HealthEventMapper.toDTO(event);
    }

    public void deleteEvent(Integer eventID){
        healthEventRepo.deleteById(eventID);
    }

}
