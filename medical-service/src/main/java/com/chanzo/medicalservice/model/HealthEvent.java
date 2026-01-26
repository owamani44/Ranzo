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
public class HealthEvent {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer eventID;

    @NotNull
    private String tagNumber;

    @Enumerated(EnumType.STRING)
    private EventType  eventType;

    @NotNull
    private String symptoms;

    @NotNull
    private LocalDateTime observedDate = LocalDateTime.now();

    @NotNull
    private String recordedBy;

    @OneToMany(mappedBy = "healthEvent")
    private List<FollowUp> followUps;


}
