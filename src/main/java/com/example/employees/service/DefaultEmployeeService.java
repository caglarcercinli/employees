package com.example.employees.service;


import com.example.employees.domain.Employee;
import com.example.employees.exception.EmployeeNietGevondenException;
import com.example.employees.repository.EmployeeRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultEmployeeService implements EmployeeService {
    private final EmployeeRepository employeeRepository;
//    private final PasswordEncoder passwordEncoder;

    public DefaultEmployeeService(EmployeeRepository employeeRepository/*, PasswordEncoder passwordEncoder*/) {
        this.employeeRepository = employeeRepository;
       // this.passwordEncoder = passwordEncoder;
    }

    @Override
    //@Transactional(readOnly = true)
    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    //@Transactional(readOnly = true)
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void create(Employee employee) {
//        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(long id) {
        try{
            employeeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EmployeeNietGevondenException();
        }
    }
}