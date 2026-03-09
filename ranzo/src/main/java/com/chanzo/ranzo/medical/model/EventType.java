package com.chanzo.ranzo.medical.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EventType {
    ILLNESS("Illness"),
    VACCINATION("Vaccination"),
    CHECKUP("Checkup"),
    INJURY("Injury");

    private final String EventType;

}
