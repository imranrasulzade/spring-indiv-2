package com.example.springindiv2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private Long userId;
    private String description;
    private Double price;
    private Integer paymentStatus;
    private Integer orderStatus;


}
