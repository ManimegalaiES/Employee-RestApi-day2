package com.example.springbootfirst.services;

import com.example.springbootfirst.models.UserDetails;
import com.example.springbootfirst.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserDetails user) {
        userRepository.save(user);
    }

    public UserDetails getUser(String empId) {
        return userRepository.findById(empId).orElse(null);
    }
}
