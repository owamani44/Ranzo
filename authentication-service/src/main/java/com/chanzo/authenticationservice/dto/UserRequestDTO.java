package com.chanzo.authenticationservice.dto;

import com.chanzo.authenticationservice.model.Roles;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    @NotBlank

    @Size(min =4, max = 50)
    private String firstName;
    @NotBlank
    @Size(min =4, max = 50)
    private String lastName;

    private String username;

    @NotBlank
    @Size(min =8, max = 50)
    private String password;

    @NotBlank
    private Roles roles;
}
