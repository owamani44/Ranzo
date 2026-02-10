package com.chanzo.authenticationservice.service;

import com.chanzo.authenticationservice.dto.LoginRequestDTO;
import com.chanzo.authenticationservice.model.UserInfo;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class UserPrincipal implements UserDetails {

    private final String username;
    private final String password;
    private final List<GrantedAuthority> authorities;


    public UserPrincipal(UserInfo userInfo) {
       username = userInfo.getUsername();
       password = userInfo.getPassword();
       authorities = Arrays.stream(userInfo.getRoles().split(","))
               .map(SimpleGrantedAuthority::new)
               .collect(Collectors.toList());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
