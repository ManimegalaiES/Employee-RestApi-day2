package com.example.springbootfirst.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserDetails {
    @Id
    private String empId;
    private String name;
    private String password;
    private String email;
    private String gender;
    private String dob; // or LocalDate
}
