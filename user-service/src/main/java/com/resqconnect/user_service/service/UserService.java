package com.resqconnect.user_service.service;

import com.resqconnect.user_service.dto.UserRegistrationRequest;
import com.resqconnect.user_service.dto.UserResponseDTO;
import com.resqconnect.user_service.dto.UserUpdateRequest;

import java.util.List;

public interface UserService {

    UserResponseDTO registerUser(UserRegistrationRequest request);

    UserResponseDTO getUserById(Integer id);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO updateUser(Integer id, UserUpdateRequest request);
    void deleteUser(Integer id);
}