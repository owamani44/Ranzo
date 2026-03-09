package com.chanzo.ranzo.registry.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AnimalStatus {
    ALIVE("Alive"),
    SOLD("Sold"),
    LOST("Lost"),
    DEAD("Dead");

    private final String status;
}
