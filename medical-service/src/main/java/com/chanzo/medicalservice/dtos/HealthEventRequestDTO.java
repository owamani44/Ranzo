package com.chanzo.medicalservice.dtos;

import com.chanzo.medicalservice.model.EventType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class HealthEventRequestDTO {

    @NotNull
    private String tagNumber;

    @NotNull
    private EventType eventType;

    @NotNull
    private String symptoms;

    @NotNull
    private String recordedBy;
}
