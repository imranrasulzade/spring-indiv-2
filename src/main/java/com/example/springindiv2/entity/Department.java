package com.example.springindiv2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "indiv_department")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String location;
    private LocalDate depCreDate;

    private LocalDateTime instanceDate;
    private LocalDateTime updateDate;

//    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
//    private List<Employee> employees;


    @PrePersist
    protected void onCreate() {
        this.instanceDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateDate = LocalDateTime.now();
    }


}
