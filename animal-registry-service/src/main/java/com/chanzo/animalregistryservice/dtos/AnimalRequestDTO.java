package com.chanzo.animalregistryservice.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class AnimalRequestDTO {

    @NotBlank
    @Size(min = 6 , max=6 , message = "Tag Number should be valid")
    private String tagNumber;

    @NotBlank
    @Size(min =2,max=12)
    private String species;

    @NotBlank
    @Size(min =5, max=12 , message="Specify the type of breed for the listed animal")
    private String breed;

    @NotBlank
    private LocalDate birthdate;

    @NotBlank
    @Size(min = 6 , max = 12, message = "Animal gender must be specified")
    private String gender;

    private String kraalAssignment;

    private LocalDateTime registeredOn = LocalDateTime.now();
}
