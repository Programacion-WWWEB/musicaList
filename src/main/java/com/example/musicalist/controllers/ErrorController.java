package com.example.musicalist.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class ErrorController {

        @RequestMapping("/error")
    public String errorPage(HttpServletRequest request, Model model) {
        
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            model.addAttribute("message", "HTTP Error " + statusCode);
        } else {
            model.addAttribute("error", "An error occurred.");
        }
        return "error"; 
    }
    
}
