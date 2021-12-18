package com.microservice.dpartments.controllers;

import com.microservice.dpartments.entities.Department;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    @GetMapping
    public Department getDepartment(){
        Department department = new Department(1, "Development");

        return department;
    }

}
