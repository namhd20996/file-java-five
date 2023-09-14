package com.example.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/home/about")
    public String aboutPage() {
        return "about";
    }
}
