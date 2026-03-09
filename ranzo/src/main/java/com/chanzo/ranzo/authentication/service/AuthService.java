package com.chanzo.ranzo.authentication.service;


import com.chanzo.ranzo.authentication.dto.LoginRequestDTO;
import com.chanzo.ranzo.authentication.util.JwtUtil;
import io.jsonwebtoken.JwtException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Locale.filter;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private  final UserInfoService userInfoService;
    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO){
        Optional<String> token = userInfoService.findByUsername
                (loginRequestDTO.getUsername())
        .filter(u->passwordEncoder.matches(loginRequestDTO.getPassword(),
                u.getPassword()))
                .map(u->jwtUtil.generateToken(u.getUsername(), String.valueOf(u.getRoles())));

        return token;
    }

    public boolean validateToken(String token) {
        try {
            jwtUtil.validateToken(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
