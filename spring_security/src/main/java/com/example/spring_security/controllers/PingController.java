package com.example.spring_security.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ping")
public class PingController {
    @GetMapping()
    public String ping() {
        return "OK";
    }
}