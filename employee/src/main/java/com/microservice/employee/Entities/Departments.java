package com.microservice.employee.Entities;

import lombok.Data;

@Data
public class Departments {
   
    private int deptId;
    private String deptName;
    
    
    public Departments() {
    }

    public Departments(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Departments [deptId=" + deptId + ", deptName=" + deptName + "]";
    }
    
}
