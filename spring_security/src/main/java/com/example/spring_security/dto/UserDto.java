package com.example.spring_security.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
}
