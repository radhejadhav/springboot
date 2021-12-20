package com.microservice.employee.Entities;

import lombok.Data;

@Data
public class EmployeeProfile {
 
    private int id;
    private String name;
    private String email;
    private Departments departments;
    

    public EmployeeProfile() {
    }


    public EmployeeProfile(int id, String name, String email, Departments departments) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departments = departments;
    }
    

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Departments getDepartments() {
        return departments;
    }


    public void setDepartments(Departments departments) {
        this.departments = departments;
    }


    @Override
    public String toString() {
        return "EmployeeProfile [departments=" + departments + ", email=" + email + ", id=" + id + ", name=" + name
                + "]";
    } 
    

}
