package com.chanzo.animalregistryservice.mapper;

import com.chanzo.animalregistryservice.dtos.AnimalRequestDTO;
import com.chanzo.animalregistryservice.dtos.AnimalResponseDTO;
import com.chanzo.animalregistryservice.model.Animal;

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
        animalDTO.setRegisteredOn(animal.getRegisteredOn());

        return animalDTO;
    }

public static Animal toModel(AnimalRequestDTO animalRequestDTO){
        Animal animal = new Animal();
        animal.setTagNumber(animalRequestDTO.getTagNumber());
        animal.setSpecies(animalRequestDTO.getSpecies());
        animal.setBreed(animalRequestDTO.getBreed());
        animal.setGender(animalRequestDTO.getGender());
        animal.setKraalAssignment(animalRequestDTO.getKraalAssignment());
        animal.setBirthDate(animalRequestDTO.getBirthdate());
        animal.setRegisteredOn(animalRequestDTO.getRegisteredOn());

        return animal;
}
}
