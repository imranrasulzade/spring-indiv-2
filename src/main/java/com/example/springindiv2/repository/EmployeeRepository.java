package com.example.springindiv2.repository;

import com.example.springindiv2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);

    @Query(value = "select e from Employee e where e.id = :exId")
    List<Employee> findByIdWithParam(@Param("exId") Integer id);

}
