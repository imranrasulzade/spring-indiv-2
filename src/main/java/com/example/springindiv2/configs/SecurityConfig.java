package com.example.springindiv2.configs;

import com.example.springindiv2.filter.JwtAuthorizationFilter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtAuthorizationFilter jwtAuthorizationFilter;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(permitAllUrls).permitAll()
                        .requestMatchers(HttpMethod.POST, "/address").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/address").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/tests", "/tests/**").hasRole("USER")
                        .anyRequest().authenticated()

                ).exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint((request, response, authException) ->
                                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED)
                        )
                        .accessDeniedHandler((request, response, accessDeniedException) ->
                                response.setStatus(HttpServletResponse.SC_FORBIDDEN)
                        )
                )
                .httpBasic(Customizer.withDefaults()
                );
        return http.build();
    }


    private String[] permitAllUrls = {
            "/api/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/auth/**"
    };




//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 =
//                User.withUsername("admin")
//                        .password(bCryptPasswordEncoder().encode("admin"))
//                        .roles("ADMIN")
//                        .build();
//
//        UserDetails user2 =
//                User.withUsername("imran")
//                        .password(bCryptPasswordEncoder().encode("imran"))
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
}
