package com.chanzo.authenticationservice.controller;

import com.chanzo.authenticationservice.dto.UserRequestDTO;
import com.chanzo.authenticationservice.dto.UserResponseDTO;
import com.chanzo.authenticationservice.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserInfoService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = userService.registerUser(userRequestDTO);
        return ResponseEntity.ok(userResponseDTO);
    }


}
