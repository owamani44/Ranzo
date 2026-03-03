package com.chanzo.authenticationservice.dto;

import com.chanzo.authenticationservice.model.Roles;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserResponseDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private Roles roles;

}
