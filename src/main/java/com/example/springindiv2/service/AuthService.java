package com.example.springindiv2.service;

import com.example.springindiv2.dto.AuthResponse;
import com.example.springindiv2.dto.LoginRequest;
import com.example.springindiv2.dto.RegisterRequest;
import com.example.springindiv2.entity.User;
import com.example.springindiv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    public AuthResponse signIn(LoginRequest request) {
        log.info("signIn request={}", request);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        log.info("Successfully authenticated user {}", authentication.getName());
        String jwtToken = jwtService.createToken(request.getUsername());
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
        return new AuthResponse(jwtToken, user.getId());
    }


    public void signUp(RegisterRequest request) {
        log.info("Sign up request received");
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEnabled(true);
        user.setRole(request.getRole());
        userRepository.save(user);
        log.info("sign up user {}", user);
    }


}
