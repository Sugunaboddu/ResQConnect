package com.resqconnect.user_service.service;

import com.resqconnect.user_service.dto.UserRegistrationRequest;
import com.resqconnect.user_service.entity.Role;
import com.resqconnect.user_service.entity.User;
import com.resqconnect.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.resqconnect.user_service.dto.UserResponseDTO;
import com.resqconnect.user_service.exception.EmailAlreadyExistsException;
import com.resqconnect.user_service.dto.UserUpdateRequest;

import java.util.List;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO registerUser(UserRegistrationRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already registered");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.CITIZEN);

        User savedUser = userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();

        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setRole(savedUser.getRole());

        return response;
    }
    public UserResponseDTO  getUserById(Integer id){
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found"));
        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        return response;
    }
    public List<UserResponseDTO> getAllUsers(){
        List<User>users=userRepository.findAll();
        return users.stream()
                .map(user->{
                    UserResponseDTO response=new UserResponseDTO();
                    response.setId(user.getId());
                      response.setName(user.getName());
                      response.setEmail(user.getEmail());
                      response.setRole(user.getRole());
                      return response;
                })
                .toList();


    }

    public UserResponseDTO updateUser(Integer id, UserUpdateRequest request) {

        // Step 1: Existing user ni database nundi find cheyyali
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Step 2: Existing user details update cheyyali
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Step 3: Updated user ni database lo save cheyyali
        User updatedUser = userRepository.save(user);

        // Step 4: Entity ni Response DTO ga convert cheyyali
        UserResponseDTO response = new UserResponseDTO();

        response.setId(updatedUser.getId());
        response.setName(updatedUser.getName());
        response.setEmail(updatedUser.getEmail());
        response.setRole(updatedUser.getRole());

        // Step 5: Response return
        return response;
    }

    public void deleteUser(Integer id) {

        // Step 1: User database lo unnado ledo check cheyyali
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Step 2: User ni database nundi delete cheyyali
        userRepository.delete(user);
    }
}