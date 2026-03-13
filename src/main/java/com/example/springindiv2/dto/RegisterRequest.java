package com.example.springindiv2.dto;

import com.example.springindiv2.enums.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
}
