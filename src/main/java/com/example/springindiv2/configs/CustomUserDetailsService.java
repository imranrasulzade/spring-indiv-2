package com.example.springindiv2.configs;

import com.example.springindiv2.entity.User;
import com.example.springindiv2.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername started by username={}", username);
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("USER NOT FOUND"));
        if (!user.getEnabled()) {
            throw new RuntimeException("USER DISABLED");
        }
        List<String> roles = new ArrayList<>();
        roles.add(user.getRole().toString());
        UserDetails userDetails;
        userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(roles.toArray(new String[0]))
                .build();
        log.info("loadUserByUsername ended by username={}", username);
        return userDetails;
    }
}