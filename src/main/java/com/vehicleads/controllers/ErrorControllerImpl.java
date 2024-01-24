package com.vehicleads.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;

@Controller
public class ErrorControllerImpl implements ErrorController {
    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request, Model model) {
        ModelAndView modelAndView = new ModelAndView("error");

        Integer statusCode = (Integer) model.asMap().get("ERROR_STATUS_CODE");
        String customMessage = (String) model.asMap().get("CUSTOM_ERROR_MESSAGE");

        if (statusCode != null) {
            modelAndView.addObject("statusCode", statusCode.toString());
        }
        else {
            statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
            modelAndView.addObject("statusCode", statusCode);
        }

        if (customMessage != null) {
            modelAndView.addObject("error", customMessage.toString());

            return modelAndView;
        }

        customMessage = (String) request.getAttribute("jakarta.servlet.error.message");
        if (customMessage == "") {
            customMessage = HttpStatus.valueOf(statusCode).getReasonPhrase();
        }
        modelAndView.addObject("error", customMessage);

        return modelAndView;
    }
}