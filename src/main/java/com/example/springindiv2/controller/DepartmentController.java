//package com.example.springindiv2.controller;
//
//import com.example.springindiv2.entity.Department;
//import com.example.springindiv2.service.DepartmentService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/departments")
//@RequiredArgsConstructor
//public class DepartmentController {
//
//    private final DepartmentService departmentService;
//
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void add(@RequestBody Department department) {
//        departmentService.add(department);
//    }
//
//    @GetMapping
//    public List<Department> getAll() {
//        return departmentService.getAll();
//    }
//
//}
