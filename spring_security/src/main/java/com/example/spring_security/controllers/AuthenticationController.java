package com.example.spring_security.controllers;

import com.example.spring_security.dto.UserDto;
import com.example.spring_security.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    private final RegistrationService registrationService;

    @Autowired
    public AuthenticationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/reg")
    public String registration(Model model){
        model.addAttribute("user", new UserDto());
        return "reg";
    }

    @PostMapping("/reg")
    public String saveUser(@ModelAttribute("user") UserDto userDto){
        registrationService.registration(userDto);
        return "redirect:/auth/login";
    }
}
