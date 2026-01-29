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
@Table(name="health_event")
public class HealthEvent {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="event_id")
    private Integer eventID;

    @NotNull
    @Column(name="tag_number")
    private String tagNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private EventType  eventType;

    @NotNull
    private String symptoms;


    @Column(name = "observed_date")
    private LocalDateTime observedDate;

    @NotNull
    @Column(name = "recorded_by")
    private String recordedBy;

    @PrePersist
    public void onCreate() {
        if (this.observedDate == null) {
            this.observedDate = LocalDateTime.now();
        }

    }

}

//    @OneToMany(mappedBy = "healthEvent")
//    private List<FollowUp> followUps;



