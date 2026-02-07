package com.chanzo.authenticationservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequestDTO {
    @NotBlank
    @Size(min=15, max=27, message = "Username must be be valid ")
    private String username;
    @NotBlank
    @Size(min =8 ,max=20 ,message = "Password must be be 8 characters long")
    private String password;
}
