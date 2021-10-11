package com.example.employees.controller;

import com.example.employees.domain.Employee;
import com.example.employees.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
    private final EmployeeService employeeService;

    public IndexController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ModelAndView index(){
        var employee = new ModelAndView("index");
        employee.addObject("candidate",new Employee("","","",""));
        return employee;
    }
//    @PostMapping
//    public ModelAndView add(Employee employee, Errors errors){
//        if (errors.hasErrors()) {
//            return new ModelAndView("index");
//        }
//        employeeService.create(employee);
//        var emp = new ModelAndView("index");
//        emp.addObject("candidate",new Employee("","","",""));
//        return emp;
//    }
}
