package com.giftbyticket.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private String email;
    private String mobile;
    private String password;
    private String role;
}

