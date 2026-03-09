package com.chanzo.ranzo.authentication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    @NotNull
    @Column(name="first_name")
    private  String firstName;
    @NotNull
    @Column(name="last_name")
    private String lastName;
    @NotNull
    @Column(unique=true)
    private String username;

    @NotNull
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles roles;


}
