package com.vehicleads.controllers;

import com.vehicleads.dtos.authentication.UserLoginDto;
import com.vehicleads.dtos.authentication.UserRegistrationDto;
import com.vehicleads.exceptions.user.EmailAlreadyInUseException;
import com.vehicleads.exceptions.user.PasswordNotMatchedException;
import com.vehicleads.implementation.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    public String register(@Valid UserRegistrationDto registrationDto, RedirectAttributes redirectAttributes) {
        try {
            userService.register(registrationDto);

            return "redirect:/login";
        }
        catch (EmailAlreadyInUseException eaiue) {
            redirectAttributes.addFlashAttribute("emailMessage", eaiue.getMessage());

            return "redirect:/register";
        } catch (PasswordNotMatchedException pnme) {
            redirectAttributes.addFlashAttribute("confirmPasswordMessage", pnme.getMessage());

            return "redirect:/register";
        }
    }
}