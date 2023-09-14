package com.example.labs.controller;

import com.example.labs.service.impl.CookieServiceImpl;
import com.example.labs.service.impl.ParamServiceImpl;
import com.example.labs.service.impl.SessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private CookieServiceImpl cookieService;
    @Autowired
    private ParamServiceImpl paramService;
    @Autowired
    private SessionServiceImpl sessionService;

    @GetMapping("/home-page")
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView postLogin() {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        Boolean remember = paramService.getBoolean("remember", false);
        if (username.equals("poly") && password.equals("123")) {
            sessionService.set("username", username);
            if (remember) {
                cookieService.add("user", username, 10);
            } else {
                cookieService.remove("user");
            }
        }
        return new ModelAndView("login");
    }
}

