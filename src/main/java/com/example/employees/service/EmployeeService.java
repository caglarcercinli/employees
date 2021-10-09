package com.example.employees.service;

import com.example.employees.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findById(long id);
    List<Employee> findAll();
    void create(Employee employee);
    void update(Employee employee);
    void delete(long id);
}
