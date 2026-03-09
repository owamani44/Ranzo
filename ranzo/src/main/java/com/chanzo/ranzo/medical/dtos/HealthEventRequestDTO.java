package com.chanzo.ranzo.medical.dtos;

import com.chanzo.ranzo.medical.model.EventType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

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
