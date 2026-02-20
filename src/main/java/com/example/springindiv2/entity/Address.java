package com.example.springindiv2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "indiv_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;
    private String city;
    private String state;

}
