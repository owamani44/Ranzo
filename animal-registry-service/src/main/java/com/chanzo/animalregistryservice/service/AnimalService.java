package com.chanzo.animalregistryservice.service;

import com.chanzo.animalregistryservice.dtos.AnimalRequestDTO;
import com.chanzo.animalregistryservice.dtos.AnimalResponseDTO;
import com.chanzo.animalregistryservice.exceptions.AnimalNotFound;
import com.chanzo.animalregistryservice.exceptions.TagNumberAlreadyExists;
import com.chanzo.animalregistryservice.mapper.AnimalMapper;
import com.chanzo.animalregistryservice.model.Animal;
import com.chanzo.animalregistryservice.repo.AnimalRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepo animalRepo;

    public AnimalService(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    public List<AnimalResponseDTO> getAnimals(){
        List<Animal> animals = animalRepo.findAll();
        return animals.stream().map(AnimalMapper::toDTO).toList();
    }

    public AnimalResponseDTO createAnimal(AnimalRequestDTO animalRequestDTO){
        if(animalRepo.existsByTagNumber(animalRequestDTO.getTagNumber()))
            throw new TagNumberAlreadyExists("An animal with the same tag number already exists"
                    + animalRequestDTO.getTagNumber());

        Animal newAnimal = AnimalMapper.toModel(animalRequestDTO);


        return AnimalMapper.toDTO(newAnimal);
    }

    public AnimalResponseDTO updateAnimalStatus(Long id, AnimalRequestDTO animalRequestDTO){
        Animal newAnimal = animalRepo.findById(id).orElseThrow(
                ()-> new AnimalNotFound("Animal not found" + id));

    }

    public void deleteAnimal(Long id){
        animalRepo.deleteById(id);
    }
}
