package com.example.springindiv2.entity;

import com.example.springindiv2.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "indiv_users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Boolean enabled;

    @Enumerated(EnumType.STRING)
    private Role role;

}
