package com.chanzo.animalregistryservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Animal {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String tagNumber;

    @NotNull
    private String species;

    @NotNull
    private String Breed;

    @NotNull
    private String gender;

    @NotNull
    private String kraalAssignment;

    @NotNull
    private LocalDate birthDate;

    @Column(nullable = false,updatable = false)
    private LocalDateTime registeredOn = LocalDateTime.now();
}
