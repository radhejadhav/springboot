package com.microservice.employee.Controllers;

import com.microservice.employee.Entities.EmployeeProfile;
import com.microservice.employee.Services.EmployeeService;

import java.net.HttpCookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getEmplyees(HttpServletRequest request, HttpServletResponse response){
        try {
            System.out.println(request.getSession().toString());
            request.getSession().invalidate();
////            Cookie c = new Cookie("name", "Radheshyam");
//            response.addCookie(c);
//            Cookie[] ck = request.getCookies();
//            for(Cookie cc:ck) {
//            	System.out.println(cc.getValue());
//            }
//            response.getWriter().print("hello world");
            System.out.println(response.getContentType());
            response.setStatus(HttpStatus.CREATED.value());;;
            System.out.println(response.getStatus()+" "+request.getSession().getId());
        	return ResponseEntity.status(response.getStatus()).body(employeeService.getAllEmployee());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
