package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/employee")
public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String routes(){
        return "Welcome to spring boot security";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employee")
    public List<Employee> getMethod(){

        return hws.getMethod();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/employee/{empid}")
    public Employee getEmployeeById(@PathVariable int empid)
    {
        return hws.getEmployeeById(empid);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employee/job/{job}")
    public List<Employee> getEmployeeByJob(@PathVariable String job)
    {
        return hws.getEmployeeByJob(job);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/employee")
    public String postMethod(@RequestBody Employee employee){
        hws.postmethodhws(employee);
        return "Employee added successfully";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employee")
    public String putMethod( @RequestBody Employee employee){
        return  hws.updateEmployee(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/employee")
    public String DeleteMethod(){
        return hws.DeleteMethod();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/employee/{empid}")
    public String DeleteById(@PathVariable int empid){
        hws.DeleteById(empid);
        return "Employee deleted successfully";
    }
}
