package com.rodin.tacoCloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TacoCloudController {

    @GetMapping("/")
    public String getTacoCloudPage() {
        return "tacoCloud";
    }
}
