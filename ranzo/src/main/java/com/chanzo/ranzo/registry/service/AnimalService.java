package com.chanzo.ranzo.registry.service;


import com.chanzo.ranzo.registry.dtos.AnimalRequestDTO;
import com.chanzo.ranzo.registry.dtos.AnimalResponseDTO;
import com.chanzo.ranzo.registry.exceptions.AnimalNotFound;
import com.chanzo.ranzo.registry.exceptions.TagNumberAlreadyExists;
import com.chanzo.ranzo.registry.mapper.AnimalMapper;
import com.chanzo.ranzo.registry.model.Animal;
import com.chanzo.ranzo.registry.model.AnimalStatus;
import com.chanzo.ranzo.registry.repo.AnimalRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnimalService {

    private final AnimalRepo animalRepo;


    public AnimalService(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;

    }
    public Map<String, Long> getRanchStats(){
        Map<String,Long> stats =new HashMap<>();
        stats.put("ALIVE",animalRepo.countAnimalByStatus(AnimalStatus.ALIVE));
        stats.put("LOST",animalRepo.countAnimalByStatus(AnimalStatus.LOST));
        stats.put("DEAD",animalRepo.countAnimalByStatus(AnimalStatus.DEAD));
        stats.put("SOLD",animalRepo.countAnimalByStatus(AnimalStatus.SOLD));

        return stats;
    }

    public List<Animal> searchAnimals(String keyword){
        return animalRepo.searchAnimals(keyword);
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

        return AnimalMapper.toDTO(newAnimal);
    }

                    /**UPDATE ANIMAL STATUS**/
    @Transactional
    public AnimalResponseDTO updateAnimalStatus(Integer id, AnimalRequestDTO animalRequestDTO){
        Animal newAnimal = animalRepo.findById(id).orElseThrow(
                ()-> new AnimalNotFound("Animal not found" + id));

            newAnimal.setStatus(animalRequestDTO.getStatus());


           Animal updatedAnimal = animalRepo.save(newAnimal);

        return AnimalMapper.toDTO(updatedAnimal);
    }
                    /**DELETE ANIMAL**/
    public void deleteAnimal(Integer id){
        animalRepo.deleteById(id);
    }
}
