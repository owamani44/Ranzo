package com.chanzo.ranzo.registry.mapper;


import com.chanzo.ranzo.registry.dtos.AnimalRequestDTO;
import com.chanzo.ranzo.registry.dtos.AnimalResponseDTO;
import com.chanzo.ranzo.registry.model.Animal;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;

@Component
public class AnimalMapper {
    public static AnimalResponseDTO toDTO(Animal animal){
        AnimalResponseDTO animalDTO = new AnimalResponseDTO();
        animalDTO.setId(animal.getId());
        animalDTO.setTagNumber(animal.getTagNumber());
        animalDTO.setStatus(animal.getStatus());
        animalDTO.setSpecies(animal.getSpecies());
        animalDTO.setBreed(animal.getBreed());
        animalDTO.setGender(animal.getGender());
        animalDTO.setKraalAssignment(animal.getKraalAssignment());
        animalDTO.setBirthDate(animal.getBirthDate());
        animalDTO.setRegisteredOn(animal.getRegisteredOn());
        animalDTO.setUpdatedOn(animal.getUpdatedOn());

        return animalDTO;
    }

public static Animal toModel(AnimalRequestDTO animalRequestDTO){
        Animal animal = new Animal();
        animal.setTagNumber(animalRequestDTO.getTagNumber());
        animal.setSpecies(animalRequestDTO.getSpecies());
        animal.setBreed(animalRequestDTO.getBreed());
        animal.setStatus(animalRequestDTO.getStatus());
        animal.setGender(animalRequestDTO.getGender());
        animal.setKraalAssignment(animalRequestDTO.getKraalAssignment());
        animal.setBirthDate(LocalDate.parse(animalRequestDTO.getBirthDate().toString()));


        return animal;
}
}
