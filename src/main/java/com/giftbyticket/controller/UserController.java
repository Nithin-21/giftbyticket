package com.giftbyticket.controller;

import com.giftbyticket.dto.LoginRequest;
import com.giftbyticket.dto.LoginResponse;
import com.giftbyticket.dto.UserRequest;
import com.giftbyticket.dto.UserResponse;
import com.giftbyticket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserResponse registerUser(
            @RequestBody UserRequest request) {

        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(
            @RequestBody LoginRequest request) {

        return userService.loginUser(request);
    }
}