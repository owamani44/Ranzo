package com.chanzo.medicalservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="medication_records")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medical_id")
    private Integer medicalID;

    @Enumerated(EnumType.STRING)
    private MedicationType type;

    @NotNull
    @Column(name="drug_name")
    private String drugName;

    @NotNull
    private String dosage;

    @NotNull
    @Column(name="administered_by")
    private String administeredBy;

    @NotNull
    @Column(name="administered_at")
    private LocalDateTime administeredAt;


}
