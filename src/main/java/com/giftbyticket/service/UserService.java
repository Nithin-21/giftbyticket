package com.giftbyticket.service;

import com.giftbyticket.dto.*;
import java.util.List;

public interface UserService {

    UserResponse registerUser(UserRequest request);
    LoginResponse loginUser(LoginRequest request);
    UserResponse getUserById(Long id);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUser(Long id);
    void forgotPassword(String email);

    void resetPassword(
            String email,
            String newPassword);
}