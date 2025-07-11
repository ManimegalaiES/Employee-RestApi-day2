package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/register")
    public String addNewUser(@RequestBody UserDetailsDto register){
        return authService.addNewEmployee(register);

    }
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody UserDetailsDto register) {
        return authService.updateUser(id,register);
    }
    @GetMapping("/users/{roleName}")
    public List<RegisterDetails> getUsersByRole(@PathVariable String roleName) {
        return authService.getUsersByRole(roleName);
    }


    @PostMapping ("/login")
    public String Login(@RequestBody RegisterDetails login){
        return authService.authenticate(login);

    }
}
