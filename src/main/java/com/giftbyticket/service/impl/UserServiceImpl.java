package com.giftbyticket.service.impl;

import com.giftbyticket.dto.LoginRequest;
import com.giftbyticket.dto.LoginResponse;
import com.giftbyticket.dto.UserRequest;
import com.giftbyticket.dto.UserResponse;
import com.giftbyticket.entity.User;
import com.giftbyticket.repository.UserRepository;
import com.giftbyticket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse registerUser(UserRequest request) {

        if (userRepository.findByEmail(request.getEmail()) != null) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .password(request.getPassword())
                .role(request.getRole())
                .build();

        User savedUser = userRepository.save(user);

        return UserResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .mobile(savedUser.getMobile())
                .role(savedUser.getRole())
                .build();
    }

    @Override
    public LoginResponse loginUser(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return LoginResponse.builder()
                .message("Login successful")
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}