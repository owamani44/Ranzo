package com.chanzo.animalregistryservice.controller;

import com.chanzo.animalregistryservice.dtos.AnimalRequestDTO;
import com.chanzo.animalregistryservice.dtos.AnimalResponseDTO;
import com.chanzo.animalregistryservice.service.AnimalService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
Author:Solomon Owamani
**/
@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService){
        this.animalService= animalService;
    }

                /**GET ALL ANIMALS ENDPOINT**/
    @Operation(summary = "Get all animals", description = "Retrieve a list of all registered animals in the system")
    @GetMapping
    public ResponseEntity<List<AnimalResponseDTO>> getAllAnimals(){
        List<AnimalResponseDTO> animals = animalService.getAnimals();
        return ResponseEntity.ok().body(animals);
    }

                        /**GET ANIMAL BY TAG NUMBER ENDPOINT**/
    @Operation(summary = "Get animal entity by tag number", description = "Retrieve details of a specific animal using its unique tag number")
    @GetMapping("/by-tag/{tagNumber}")
    public ResponseEntity<AnimalResponseDTO> getByTag(@PathVariable String tagNumber){
        AnimalResponseDTO animalTag = animalService.getByTagNumber(tagNumber);
        return ResponseEntity.ok().body(animalTag);
    }
                /**REGISTER ANIMAL ENDPOINT**/
    @Operation(summary="Register animal", description="Registers a new animal in the system with the provided details")
    @PostMapping
    public ResponseEntity<AnimalResponseDTO> createAnimal(@Valid @RequestBody
                                                              AnimalRequestDTO animalRequestDTO)
        {
            AnimalResponseDTO animalResponseDTO= animalService.createAnimal(animalRequestDTO);
           return ResponseEntity.ok().body(animalResponseDTO);
        }


                /**DELETE STATUS ENDPOINT**/
    @Operation(summary="Deletes animal entity ", description = "Removes animal entity from the system")
    @DeleteMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> deleteAnimal(@PathVariable Integer id){
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }

                /**UPDATE STATUS ENDPOINT**/
    @Operation(summary ="Updates animal entity",description = "Updates animals details in the system")
    @PatchMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> updateAnimalStatus(@PathVariable Integer id, @Validated({
        Default.class}) @RequestBody AnimalRequestDTO animalRequestDTO){
        AnimalResponseDTO update = animalService.updateAnimalStatus(id,animalRequestDTO);
        return ResponseEntity.ok().body(update);
    }
}
