package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.UserDetails;
import com.example.springbootfirst.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // POST API to register a user
    @PostMapping("/register")
    public String registerUser(@RequestBody UserDetails user) {
        userService.saveUser(user);
        return "User registered successfully!";
    }

    // GET API to view user (optional)
    @GetMapping("/{empId}")
    public UserDetails getUser(@PathVariable String empId) {
        return userService.getUser(empId);
    }
}
