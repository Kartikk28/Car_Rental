package com.example.car_rental.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String homePage() {
        return "home";  // This must match a Thymeleaf template or HTML file in src/main/resources/templates/
    }
}
