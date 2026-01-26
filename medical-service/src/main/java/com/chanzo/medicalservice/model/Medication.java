package com.chanzo.medicalservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicalID;


    @Enumerated(EnumType.STRING)
    private MedicationType type;

    @NotNull
    private String drugName;

    @NotNull
    private String dosage;

    @NotNull
    private String administeredBy;

    @NotNull
    private LocalDateTime administeredAt;


}
