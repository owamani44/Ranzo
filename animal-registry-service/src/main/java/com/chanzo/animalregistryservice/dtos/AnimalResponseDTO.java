package com.chanzo.animalregistryservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class AnimalResponseDTO {
    private Long id;
    private String tagNumber;
    private String species;
    private String breed;
    private String gender;
    private String kraalAssignment;
    private LocalDate birthDate;
    private LocalDateTime registeredOn;
}
