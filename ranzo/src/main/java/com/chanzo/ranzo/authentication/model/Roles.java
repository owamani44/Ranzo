package com.chanzo.ranzo.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Roles {
    MANAGER("Manager"),
    VET("Vet"),
    FARM_OPERATOR("FARM OPERATOR");

        private final String roles;


    public String[] split(String s) {
        return null;
    }
}
