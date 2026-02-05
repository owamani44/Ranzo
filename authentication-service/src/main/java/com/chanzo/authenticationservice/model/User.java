package com.chanzo.authenticationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    @NotNull
    private  String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String username;

    @NotNull
    private String password;





}
