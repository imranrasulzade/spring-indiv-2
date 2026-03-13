package com.example.springindiv2.controller;

import com.example.springindiv2.dto.AuthResponse;
import com.example.springindiv2.dto.LoginRequest;
import com.example.springindiv2.dto.RegisterRequest;
import com.example.springindiv2.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-in")
    public AuthResponse signIn(@RequestBody LoginRequest loginRequest) {
        return authService.signIn(loginRequest);
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody RegisterRequest request) {
        authService.signUp(request);
    }

}
