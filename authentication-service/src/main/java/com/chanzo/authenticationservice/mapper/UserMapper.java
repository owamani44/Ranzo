package com.chanzo.authenticationservice.mapper;


import com.chanzo.authenticationservice.dto.UserRequestDTO;
import com.chanzo.authenticationservice.dto.UserResponseDTO;
import com.chanzo.authenticationservice.model.UserInfo;

public class UserMapper {
    public static UserResponseDTO toDTO(UserInfo userInfo){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(userInfo.getId());
        userResponseDTO.setFirstName(userInfo.getFirstName());
        userResponseDTO.setLastName(userInfo.getLastName());
        userResponseDTO.setUsername(userInfo.getUsername());
        userResponseDTO.setRole(userInfo.getRole());
        return userResponseDTO;
    }

    public static UserInfo toModel(UserRequestDTO userRequestDTO){
        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName(userRequestDTO.getFirstName());
        userInfo.setLastName(userRequestDTO.getLastName());
        userInfo.setUsername(userRequestDTO.getUsername());
        userInfo.setPassword(userRequestDTO.getPassword());
        userInfo.setRole(userRequestDTO.getRole());
        return userInfo;
    }
}
