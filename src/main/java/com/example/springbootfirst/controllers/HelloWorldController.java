package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/employee")
public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;

    @GetMapping("/")
    public String routes(){
        return "Welcome to spring boot security";
    }

    @GetMapping("/employee")
    public List<Employee> getMethod(){

        return hws.getMethod();
    }

    @GetMapping("/employee/{empid}")
    public Employee getEmployeeById(@PathVariable int empid)
    {
        return hws.getEmployeeById(empid);
    }

    @GetMapping("/employee/job/{job}")
    public List<Employee> getEmployeeByJob(@PathVariable String job)
    {
        return hws.getEmployeeByJob(job);
    }

    @PostMapping("/employee")
    public String postMethod(@RequestBody Employee employee){
        hws.postmethodhws(employee);
        return "Employee added successfully";
    }

//    @PutMapping("/employee")
//    public String putMethod(@RequestBody Employee employee){
//        return hws.putMethod(employee);
//    }

    @DeleteMapping("/employee")
    public String DeleteMethod(){
        return hws.DeleteMethod();
    }

    @DeleteMapping("/employee/{empid}")
    public String DeleteById(@PathVariable int empid){
        hws.DeleteById(empid);
        return "Employee deleted successfully";
    }
}
