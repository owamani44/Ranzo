package com.chanzo.animalregistryservice.service;

import com.chanzo.animalregistryservice.dtos.AnimalRequestDTO;
import com.chanzo.animalregistryservice.dtos.AnimalResponseDTO;
import com.chanzo.animalregistryservice.exceptions.AnimalNotFound;
import com.chanzo.animalregistryservice.exceptions.TagNumberAlreadyExists;
import com.chanzo.animalregistryservice.mapper.AnimalMapper;
import com.chanzo.animalregistryservice.model.Animal;
import com.chanzo.animalregistryservice.model.AnimalOutbox;
import com.chanzo.animalregistryservice.repo.AnimalOutboxRepo;
import com.chanzo.animalregistryservice.repo.AnimalRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepo animalRepo;
    private final AnimalOutboxRepo animalOutboxRepo;


    public AnimalService(AnimalRepo animalRepo, AnimalOutboxRepo animalOutboxRepo) {
        this.animalRepo = animalRepo;
        this.animalOutboxRepo = animalOutboxRepo;
    }
                          /**GET ALL ANIMALS**/
    public List<AnimalResponseDTO> getAnimals(){
        List<Animal> animals = animalRepo.findAll();
        return animals.stream().map(AnimalMapper::toDTO).toList();
    }

                        /**GET ANIMAL BY TAG NUMBER METHOD**/
    public AnimalResponseDTO getByTagNumber(String tagNumber){
        Animal animal = animalRepo.findByTagNumber(tagNumber).
                orElseThrow(()->new AnimalNotFound("Animal not found "+ tagNumber));

                return AnimalMapper.toDTO(animal);
    }

                    /**REGISTERING ANIMAL METHOD**/
    @Transactional
    public AnimalResponseDTO createAnimal(AnimalRequestDTO animalRequestDTO){
        if(animalRepo.existsByTagNumber(animalRequestDTO.getTagNumber()))
            throw new TagNumberAlreadyExists("An animal with the same tag number already exists  "
                    + animalRequestDTO.getTagNumber());

        Animal newAnimal = animalRepo.save(AnimalMapper.toModel(animalRequestDTO));

        AnimalOutbox outbox = animalOutboxRepo.save(AnimalMapper.toOutboxModel(newAnimal));

        return AnimalMapper.toDTO(newAnimal);
    }

                    /**UPDATE ANIMAL STATUS**/
    @Transactional
    public AnimalResponseDTO updateAnimalStatus(Integer id, AnimalRequestDTO animalRequestDTO){
        Animal newAnimal = animalRepo.findById(id).orElseThrow(
                ()-> new AnimalNotFound("Animal not found" + id));

            newAnimal.setStatus(animalRequestDTO.getStatus());


           Animal updatedAnimal = animalRepo.save(newAnimal);

           //Save to outbox database
           AnimalOutbox outbox =animalOutboxRepo.save(AnimalMapper.toOutboxModel(updatedAnimal));


        return AnimalMapper.toDTO(updatedAnimal);
    }
                    /**DELETE ANIMAL**/
    public void deleteAnimal(Integer id){
        animalRepo.deleteById(id);
    }
}
