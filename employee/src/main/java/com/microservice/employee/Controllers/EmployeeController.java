package com.microservice.employee.Controllers;

import com.microservice.employee.Entities.EmployeeProfile;
import com.microservice.employee.Services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public EmployeeProfile getEmplyees(){
        try {
            
        return employeeService.getAllEmployee();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
