package com.chanzo.medicalservice.model;

import com.sun.java.accessibility.util.EventID;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class TreatmentPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tpID;

    @ManyToMany(mappedBy= "treatmentPlans")
    private List<HealthEvent> healthEvent;

    @Enumerated(EnumType.STRING)
    private TreatmentPlanStatus status;

    @NotNull
    private String responsibleVet;

    @NotNull
    private LocalDateTime startedAt;

    @NotNull
    private LocalDateTime finishedAt;

    @NotNull
    private LocalDateTime updatedAt;

    @ManyToMany(mappedBy = "treatmentPlan")
    private List<MedicalAction> medicalActions;

    @OneToMany(mappedBy = "treatmentPlan")
    private List<FollowUp> followUps;



}
