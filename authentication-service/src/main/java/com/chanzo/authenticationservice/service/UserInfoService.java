package com.chanzo.authenticationservice.service;

import com.chanzo.authenticationservice.dto.UserRequestDTO;
import com.chanzo.authenticationservice.dto.UserResponseDTO;
import com.chanzo.authenticationservice.mapper.UserMapper;
import com.chanzo.authenticationservice.model.UserInfo;
import com.chanzo.authenticationservice.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserInfoService  {

    private final UserRepo repo;
    private final PasswordEncoder passwordEncoder;

    public String generateUsername(String firstName, String lastName) {
        String base = (firstName.substring(0,1) + lastName).toLowerCase();

        String username = base;
        int counter = 1;
        while (repo.existsByUsername(username)) {
            username = base + counter;
            counter++;
        }
        return username;
    }

    @Transactional
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO){
        UserInfo newUserInfo = UserMapper.toModel(userRequestDTO);
        String username = generateUsername(newUserInfo.getFirstName(),
                newUserInfo.getLastName() );
        newUserInfo.setUsername(username);
        newUserInfo.setPassword(passwordEncoder.encode(newUserInfo.getPassword()));
        UserInfo savedUserInfo = repo.save(newUserInfo);
        return UserMapper.toDTO(savedUserInfo);
    }

    public Optional<UserInfo> findByUsername(String username){
        return repo.findByUsername(username);
    }


}
