package com.example.labs.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeAPI {

    @GetMapping("/api-home")
    public String homePage() {
        return "Success";
    }
}
