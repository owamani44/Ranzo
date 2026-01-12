package com.chanzo.animalregistryservice.controller;

import com.chanzo.animalregistryservice.dtos.AnimalRequestDTO;
import com.chanzo.animalregistryservice.dtos.AnimalResponseDTO;
import com.chanzo.animalregistryservice.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService){
        this.animalService= animalService;
    }

    @GetMapping
    public ResponseEntity<List<AnimalResponseDTO>> getAllAnimals(){
        List<AnimalResponseDTO> animals = animalService.getAnimals();
        return ResponseEntity.ok().body(animals);
    }

    @PostMapping
    public ResponseEntity<AnimalResponseDTO> createAnimal(@Valid @RequestBody
                                                              AnimalRequestDTO animalRequestDTO)
        {
            AnimalResponseDTO animalResponseDTO= animalService.createAnimal(animalRequestDTO);
           return ResponseEntity.ok().body(animalResponseDTO);
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> deleteAnimal(@PathVariable Long id){
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }
}
