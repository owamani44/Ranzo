package com.chanzo.ranzo.authentication.config;


import com.chanzo.ranzo.authentication.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;




@Configuration
@EnableWebSecurity
public class SecurityConfig {

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // disable CSRF for simplicity adjust for production
        http.csrf(AbstractHttpConfigurer::disable);

        // allow auth endpoints; require authentication elsewhere
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
        );
        return http.build();
     }

     // Use the injected UserService (which should implement UserDetailsService) for authentication
    @Bean
    public AuthenticationProvider authenticationProvider(UserService userService, PasswordEncoder passwordEncoder){
        DaoAuthenticationProvider authenticationProvider  = new DaoAuthenticationProvider(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }



     @Bean
     public PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder(12);
     }
 }
