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
@RequestMapping("/congrats")
public class CongratsController {
    private final EmployeeService employeeService;

    public CongratsController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ModelAndView congrats(){
        return new ModelAndView("congrats");
    }

    @PostMapping
    public ModelAndView add(Employee employee, Errors errors){
        if (errors.hasErrors()) {
            return new ModelAndView("index");
        }
        employeeService.create(employee);
        var emp = new ModelAndView("congrats");
        //emp.addObject("candidate",new Employee("","","",""));
        return emp;
    }
}
