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
@Table(name="animals")
public class Animal {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "tag_number", unique = true)
    private String tagNumber;

    @NotNull
    private String species;

    @NotNull
    private String breed;

    @NotNull
    private String gender;

    @NotNull
    @Column(name="kraal_assignment")
    private String kraalAssignment;

    @Enumerated(EnumType.STRING)
    @NotNull
    private AnimalStatus status;

    @NotNull
    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(name="registered_on",nullable = false, updatable= false)
    private LocalDateTime registeredOn;

    @NotNull
    @Column(name="updated_on",nullable = false,updatable = true)
    private LocalDateTime updatedOn ;

    @PrePersist
    public void onCreate() {
        this.registeredOn = LocalDateTime.now();
        this.updatedOn = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedOn = LocalDateTime.now();
    }
}
