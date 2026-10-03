package com.resqconnect.user_service.controller;

import com.resqconnect.user_service.dto.UserRegistrationRequest;
import com.resqconnect.user_service.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.resqconnect.user_service.dto.UserResponseDTO;
import com.resqconnect.user_service.dto.UserUpdateRequest;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/register")
    public UserResponseDTO register(@Valid @RequestBody UserRegistrationRequest request) {
        return userServiceImpl.registerUser(request);
    }
    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Integer id){
        return userServiceImpl.getUserById(id);

    }
    @GetMapping
    public List<UserResponseDTO> getAllUsers(){
        return userServiceImpl.getAllUsers();

    }
    @PutMapping("/{id}")
    public UserResponseDTO updateUser(
            @PathVariable Integer id,
            @Valid @RequestBody UserUpdateRequest request) {

        return userServiceImpl.updateUser(id, request);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {

        userServiceImpl.deleteUser(id);
    }
}