package com.chanzo.animalregistryservice.dtos;

import com.chanzo.animalregistryservice.model.AnimalStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class AnimalResponseDTO {
    private Integer id;
    private String tagNumber;
    private String species;
    private AnimalStatus status;
    private String breed;
    private String gender;
    private String kraalAssignment;
    private LocalDate birthDate;
    private LocalDateTime registeredOn;
    private LocalDateTime updatedOn;
}
