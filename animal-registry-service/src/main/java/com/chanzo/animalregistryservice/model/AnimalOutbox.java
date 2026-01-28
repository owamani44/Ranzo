package com.chanzo.animalregistryservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="animal_outbox")
public class AnimalOutbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="outbox_id")
    private Integer outBoxID;
    @Column(name="aggregate_id")
    private String aggregateID;
    @Column(name="registered")
    private Boolean registered;
    private String payload;
    @Column(name="created_on")
    private LocalDateTime createdOn;
}
