package com.example.springindiv2.service;

import com.example.springindiv2.entity.Employee;
import com.example.springindiv2.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public void add(Employee employee){
        log.info("employee adding started");
        employeeRepository.save(employee);
        log.info("employee adding finished");
    }


    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public Employee getById(int id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            return employeeOptional.get();
        }
        log.error("employee not found with id: {}", id);
        throw new RuntimeException("Employee not found");
    }

    public void edit(Employee employee) {
       Employee existingEmployee = employeeRepository.findById(employee.getId())
               .orElseThrow(() -> new RuntimeException("Employee not found"));
//       existingEmployee.setName(employee.getName());
//       existingEmployee.setSurname(employee.getSurname());
//       existingEmployee.setBirthdate(employee.getBirthdate());
//       existingEmployee.setStatus(employee.getStatus());
//       employeeRepository.save(existingEmployee);
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getByName(String name) {
        return employeeRepository.findByName(name);
    }




}
