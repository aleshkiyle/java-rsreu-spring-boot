package com.rodin.sanitaryEngineeringShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sanitaryShop")
public class SanitaryEngineeringShopController {

    @GetMapping(value = "/homePage")
    public String getHomePage() {
        return "sanitaryEngineeringShop";
    }
}
