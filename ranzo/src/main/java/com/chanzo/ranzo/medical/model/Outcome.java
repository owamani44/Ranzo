package com.chanzo.ranzo.medical.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Outcome {
    RECOVERED("Recovered"),
    IMPROVING("Improving"),
    NO_CHANGE("No Change"),
    WORSENED("Worsened");

    private final String outcome;
}
