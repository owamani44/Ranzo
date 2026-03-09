package com.chanzo.ranzo.medical.service;


import com.chanzo.ranzo.medical.dtos.HealthEventRequestDTO;
import com.chanzo.ranzo.medical.dtos.HealthEventResponseDTO;
import com.chanzo.ranzo.medical.exceptions.AnimalNotFound;
import com.chanzo.ranzo.medical.mapper.HealthEventMapper;
import com.chanzo.ranzo.medical.model.HealthEvent;
import com.chanzo.ranzo.medical.repo.HealthEventRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public HealthEventResponseDTO getEventByTagNumber(String tagNumber){
        HealthEvent event1 = healthEventRepo.findByTagNumber(tagNumber).
                orElseThrow(()->new AnimalNotFound("Animal with the following tag number not found: "+ tagNumber));
        return HealthEventMapper.toDTO(event1);
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
