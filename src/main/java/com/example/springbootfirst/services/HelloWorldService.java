package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List<Employee> emp = new ArrayList<>(
            Arrays.asList(new Employee(1,"Prasanth","Trainer"),
                    new Employee(2,"Yuvaraj","Faculty"))
    );
    public List<Employee> getMethod() {
        return emp;
    }

    public void postmethodhws(Employee employee) {
        emp.add(employee);
    }

    public String putMethod() {
        return "This is Put Method";
    }

    public String DeleteMethod() {
        return "This is Delete Method";
    }
}
