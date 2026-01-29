package com.chanzo.weightrecordservice.dtos;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class WeightRequestDTO {
    @NotBlank
    private String tagNumber;

    @NotNull
    @Min(1)
    @Max(10000)
    private Long weight;

}
