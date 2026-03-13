package com.example.springindiv2.filter;

import com.example.springindiv2.entity.User;
import com.example.springindiv2.repository.UserRepository;
import com.example.springindiv2.service.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        try {
            String accessToken = jwtService.resolveToken(request);
            if (accessToken == null ) {
                filterChain.doFilter(request, response);
                return;
            }
            //log.info("token: {} ", accessToken);
            Claims claims = jwtService.resolveClaims(request);

            if(claims != null & jwtService.validateClaims(claims)){
                String username = claims.getSubject();
                User user = userRepository.findByUsername(username)
                        .orElseThrow(() -> new RuntimeException("User not found"));
                Collection<GrantedAuthority> authorities =
                        List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
                //log.info("user : {} ", user);
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(username,"",authorities);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                //log.info("authentication : {} ", authentication);
            }
        }catch (Exception e){
            log.error("Error due to: {}", e.getClass().getName() + " -> " + e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}