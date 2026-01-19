package com.chanzo.medicalservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class MedicalAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicalID;

    @ManyToMany
    @JoinTable(
            name = "medical_plan",
            joinColumns = @JoinColumn(name="medicailID"),
            inverseJoinColumns = @JoinColumn(name = "tpID")
    )
    private List<TreatmentPlan> treatmentPlan;

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
