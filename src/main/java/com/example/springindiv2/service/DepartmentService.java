package com.example.springindiv2.service;

import com.example.springindiv2.entity.Department;
import com.example.springindiv2.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public void add(Department department) {
        departmentRepository.save(department);
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}
