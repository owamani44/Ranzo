package com.chanzo.animalregistryservice.dtos;

import com.chanzo.animalregistryservice.model.AnimalStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class AnimalRequestDTO {

    @NotBlank
    @Size(min = 6 , max=8 , message = "Tag Number should be valid")
    private String tagNumber;

    @NotBlank
    @Size(min =2,max=12)
    private String species;

    @NotNull
    private AnimalStatus status;

    @NotBlank
    @Size(min =5, max=12 , message="Specify the type of breed for the listed animal")
    private String breed;

    @NotNull
    @PastOrPresent(message = "Birth date of the animal should be included")
    private LocalDate birthDate;

    @NotBlank
    @Size(min = 2, max = 12, message = "Animal gender must be specified")
    private String gender;

    @NotBlank
    private String kraalAssignment;
}
