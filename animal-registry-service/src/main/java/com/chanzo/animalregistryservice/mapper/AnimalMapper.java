package com.chanzo.animalregistryservice.mapper;

import com.chanzo.animalregistryservice.dtos.AnimalRequestDTO;
import com.chanzo.animalregistryservice.dtos.AnimalResponseDTO;
import com.chanzo.animalregistryservice.model.Animal;
import com.chanzo.animalregistryservice.model.AnimalOutbox;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;

@Component
public class AnimalMapper {
    public static AnimalResponseDTO toDTO(Animal animal){
        AnimalResponseDTO animalDTO = new AnimalResponseDTO();
        animalDTO.setId(animal.getId());
        animalDTO.setTagNumber(animal.getTagNumber());
        animalDTO.setSpecies(animal.getSpecies());
        animalDTO.setBreed(animal.getBreed());
        animalDTO.setGender(animal.getGender());
        animalDTO.setKraalAssignment(animal.getKraalAssignment());
        animalDTO.setBirthDate(animal.getBirthDate());
        animalDTO.setUpdatedOn(animal.getUpdatedOn());

        return animalDTO;
    }

public static Animal toModel(AnimalRequestDTO animalRequestDTO){
        Animal animal = new Animal();
        animal.setTagNumber(animalRequestDTO.getTagNumber());
        animal.setSpecies(animalRequestDTO.getSpecies());
        animal.setBreed(animalRequestDTO.getBreed());
        animal.setGender(animalRequestDTO.getGender());
        animal.setKraalAssignment(animalRequestDTO.getKraalAssignment());
        animal.setBirthDate(LocalDate.parse(animalRequestDTO.getBirthdate()));
        animal.setRegisteredOn(animalRequestDTO.getRegisteredOn());
        animal.setUpdatedOn(animalRequestDTO.getUpdatedOn());

        return animal;
}
public static AnimalOutbox toOutboxModel(Animal animal){
        AnimalOutbox animalOutbox = new AnimalOutbox();
        animalOutbox.setAggregateID(animal.getTagNumber());
        animalOutbox.setPayload(new ObjectMapper().writeValueAsString(animal));
        animalOutbox.setCreatedOn(animal.getUpdatedOn());



        return animalOutbox;
}
}
