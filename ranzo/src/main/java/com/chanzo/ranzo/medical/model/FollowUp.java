//package com.chanzo.medicalservice.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Getter
//@Setter
//public class FollowUp {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer followUpId;
//
//    @ManyToOne
//    @JoinColumn(name="report_follow")
//    private HealthEvent healthEvent;
//
//    @Enumerated(EnumType.STRING)
//    private Outcome outcome;
//
//    @NotNull
//    private LocalDateTime createTime= LocalDateTime.now();
//
//}
