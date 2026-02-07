package com.chanzo.authenticationservice.service;

import com.chanzo.authenticationservice.model.UserInfo;
import com.chanzo.authenticationservice.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepo repo;

    public UserService() {

    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repo.findByUsername(username);

        return userInfo.map(UserPrincipal::new)
                .orElseThrow(
                        () -> new UsernameNotFoundException
                                ("User not found with username: " + username));

    }
}
