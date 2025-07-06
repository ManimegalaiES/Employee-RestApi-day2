package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;

    @GetMapping
    public List<Employee> getMethod(){

        return hws.getMethod();
    }

    @GetMapping("/{empid}")
    public Employee getEmployeeById(@PathVariable int empid)
    {
        return hws.getEmployeeById(empid);
    }

    @PostMapping
    public String postMethod(@RequestBody Employee employee){
        hws.postmethodhws(employee);
        return "Employee added successfully";
    }
    @PutMapping("/{empid}")
    public String putMethod(@RequestBody Employee employee){
        return hws.putMethod(employee);
    }
    @DeleteMapping
    public String DeleteMethod(){
        return hws.DeleteMethod();
    }
    @DeleteMapping("/{empid}")
    public void DeleteById(@PathVariable int empid){
        hws.DeleteById(empid);
    }
}
