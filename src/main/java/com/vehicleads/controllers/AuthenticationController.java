package com.vehicleads.controllers;

import com.vehicleads.dtos.authentication.UserLoginDto;
import com.vehicleads.dtos.authentication.UserRegistrationDto;
import com.vehicleads.exceptions.user.EmailAlreadyInUseException;
import com.vehicleads.implementation.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginDto", new UserLoginDto());

        return "authentication/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registrationDto", new UserRegistrationDto());

        return "authentication/register";
    }


    @PostMapping("/register")
    public String register(UserRegistrationDto registrationDto) { //Valid
        try {
            userService.register(registrationDto);
        } catch (EmailAlreadyInUseException e) {
            return e.getMessage();
        }

        return "redirect:/login";
    }
}