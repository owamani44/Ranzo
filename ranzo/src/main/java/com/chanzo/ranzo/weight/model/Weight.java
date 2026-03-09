package com.chanzo.ranzo.weight.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
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

    private Double weight;

    @Column(name="medical_follow_up_required")
    private boolean medicalFollowUpRequired;

    @Column(name="average_daily_gain")
    private Double averageDailyGain;

    @Column(name="first_measured_on")
    private LocalDate firstMeasuredOn;

    @Column(name="last_measured_on")
    private LocalDate lastMeasuredOn;

    @PrePersist
    public void onCreate(){
        this.firstMeasuredOn = LocalDate.now();
        this.lastMeasuredOn=LocalDate.now();
    }

    @PreUpdate
    public void onUpdate(){
        this.lastMeasuredOn=LocalDate.now();
    }
}
