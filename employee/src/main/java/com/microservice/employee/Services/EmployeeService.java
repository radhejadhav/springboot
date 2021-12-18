package com.microservice.employee.Services;

import com.microservice.employee.Entities.Departments;
import com.microservice.employee.Entities.EmployeeProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    @Autowired
    private RestTemplate restTemplate;

    public EmployeeProfile getAllEmployee(){
        // Departments departments = new Departments(1,"Computer");

        Departments departments2 = restTemplate.getForEntity("http://localhost:8081/department", Departments.class).getBody();

        EmployeeProfile employeeProfile = new EmployeeProfile(1,"Radheshyam","radhejadhav@GMAIL.COM",departments2);

        System.out.println(employeeProfile);
        return employeeProfile;
    }
    
}
