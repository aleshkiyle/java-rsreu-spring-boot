package com.rodin.sanitaryEngineeringShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/homePage")
    public String getHomePage() {
        return "homePage";
    }
}
