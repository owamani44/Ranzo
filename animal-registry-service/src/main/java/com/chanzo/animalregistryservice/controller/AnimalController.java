package com.chanzo.animalregistryservice.controller;

import com.chanzo.animalregistryservice.dtos.AnimalRequestDTO;
import com.chanzo.animalregistryservice.dtos.AnimalResponseDTO;
import com.chanzo.animalregistryservice.service.AnimalService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
Author:Solomon Owamani
**/

@RestController
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService){
        this.animalService= animalService;
    }

                /**GET ALL ANIMALS ENDPOINT**/
    @GetMapping
    public ResponseEntity<List<AnimalResponseDTO>> getAllAnimals(){
        List<AnimalResponseDTO> animals = animalService.getAnimals();
        return ResponseEntity.ok().body(animals);
    }

                        /**GET ANIMAL BY TAG NUMBER ENDPOINT**/
    @GetMapping("/by-tag/{tagNumber}")
    public ResponseEntity<AnimalResponseDTO> getByTag(@PathVariable String tagNumber){
        AnimalResponseDTO animalTag = animalService.getByTgNumber(tagNumber);
        return ResponseEntity.ok().body(animalTag);
    }
                /**REGISTER ANIMAL ENDPOINT**/
    @PostMapping
    public ResponseEntity<AnimalResponseDTO> createAnimal(@Valid @RequestBody
                                                              AnimalRequestDTO animalRequestDTO)
        {
            AnimalResponseDTO animalResponseDTO= animalService.createAnimal(animalRequestDTO);
           return ResponseEntity.ok().body(animalResponseDTO);
        }


                /**DELETE STATUS ENDPOINT**/
    @DeleteMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> deleteAnimal(@PathVariable Long id){
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }

                /**UPDATE STATUS ENDPOINT**/
    @PatchMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> updateAnimalStatus(@PathVariable Long id, @Validated({
        Default.class}) @RequestBody AnimalRequestDTO animalRequestDTO){
        AnimalResponseDTO update = animalService.updateAnimalStatus(id,animalRequestDTO);
        return ResponseEntity.ok().body(update);
    }
}
