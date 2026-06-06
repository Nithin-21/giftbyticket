package com.giftbyticket.service;

import com.giftbyticket.dto.*;

public interface UserService {

    UserResponse registerUser(UserRequest request);
    LoginResponse loginUser(LoginRequest request);
}