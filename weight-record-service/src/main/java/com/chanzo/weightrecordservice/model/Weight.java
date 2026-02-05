package com.chanzo.weightrecordservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="weight_records")
public class Weight {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="weight_id")
    private Integer weightId;
    @Column(name="tag_number")
    private String tagNumber;
    private Long weight;
    @Column(name="medical_follow_up_required")
    private boolean medicalFollowUpRequired;
    @Column(name="first_measured_on")
    private LocalDateTime firstMeasuredOn;
    @Column(name="last_measured_on")
    private LocalDateTime lastMeasuredOn;

    @PrePersist
    public void onCreate(){
        this.firstMeasuredOn = LocalDateTime.now();
        this.lastMeasuredOn=LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate(){
        this.lastMeasuredOn=LocalDateTime.now();
    }
}
