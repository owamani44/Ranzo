package com.chanzo.authenticationservice.controller;

import com.chanzo.authenticationservice.dto.LoginRequestDTO;
import com.chanzo.authenticationservice.dto.LoginResponseDTO;
import com.chanzo.authenticationservice.dto.UserRequestDTO;
import com.chanzo.authenticationservice.dto.UserResponseDTO;
import com.chanzo.authenticationservice.service.AuthService;
import com.chanzo.authenticationservice.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class UserController {

    private final UserInfoService userInfoService;
    private final AuthService authService;

    @Operation(summary="Register a new user",
            description="Create a new user account with the provided details.")
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = userInfoService.registerUser(userRequestDTO);
        return ResponseEntity.ok(userResponseDTO);
    }
    @Operation(summary="Login user",
            description="Authenticate user and return a JWT token if credentials are valid.")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody LoginRequestDTO loginRequestDTO){
        Optional<String> tokenOptional = authService.authenticate(loginRequestDTO);
        if (tokenOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String token = tokenOptional.get();
        return ResponseEntity.ok().body(new LoginResponseDTO(token));
    }

    @Operation(summary="Validate JWT token",
            description="Validate the provided JWT token and return 200 OK if valid, or 401 Unauthorized if invalid.")
    @GetMapping("/validate")
    public ResponseEntity<Void> validateToken(@RequestHeader("Authorization") String authHeader ) {

        //authorisation:bearer <token>
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
       return authService.validateToken(authHeader.substring(7))
               ? ResponseEntity.ok().build()
               : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


}
