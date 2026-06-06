package com.giftbyticket.controller;

import com.giftbyticket.dto.LoginRequest;
import com.giftbyticket.dto.LoginResponse;
import com.giftbyticket.dto.UserRequest;
import com.giftbyticket.dto.UserResponse;
import com.giftbyticket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.giftbyticket.dto.ForgotPasswordRequest;
import com.giftbyticket.dto.ResetPasswordRequest;

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
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @GetMapping
    public List<UserResponse> getAllUsers() {

        return userService.getAllUsers();
    }
    @PutMapping("/{id}")
    public UserResponse updateUser(
            @PathVariable Long id,
            @RequestBody UserRequest request) {

        return userService.updateUser(id, request);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
    }
    @PostMapping("/forgot-password")
    public String forgotPassword(
            @RequestBody ForgotPasswordRequest request) {

        userService.forgotPassword(
                request.getEmail());

        return "Password reset request received";
    }
    @PostMapping("/reset-password")
    public String resetPassword(
            @RequestBody ResetPasswordRequest request) {

        userService.resetPassword(
                request.getEmail(),
                request.getNewPassword());

        return "Password reset successful";
    }
}