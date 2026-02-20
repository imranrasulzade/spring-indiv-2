//package com.example.springindiv2.controller;
//
//import com.example.springindiv2.entity.Employee;
//import com.example.springindiv2.service.EmployeeService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/employees")
//@RequiredArgsConstructor
//public class EmployeeController {
//
//    private final EmployeeService employeeService;
//
////    public EmployeeController(EmployeeService employeeService) {
////        this.employeeService = employeeService;
////    }
//
//    @GetMapping
//    public ResponseEntity<List<Employee>> getEmployees() {
//        List<Employee> employeeList = employeeService.getEmployeeList();
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .header("Accept-Language", "az")
//                .body(employeeList);
//    }
//
//    @GetMapping("{id}")
//    public Employee getEmployee(@PathVariable int id) {
//        return employeeService.getById(id);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void add(@RequestBody Employee employee) {
//        employeeService.add(employee);
//    }
//
//    @PutMapping
//    public void update(@RequestBody Employee employee) {
//        employeeService.edit(employee);
//    }
//
//    @DeleteMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable int id) {
//        employeeService.deleteById(id);
//    }
//
//    @GetMapping("/name")
//    public ResponseEntity<?> getByName(@RequestParam String name) {
//        return ResponseEntity.ok(employeeService.getByName(name));
//    }
//
//
//
//
//}
