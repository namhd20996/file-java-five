package com.example.labs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestScope
public class ResultController {

    @GetMapping("/a")
    public String m1(@RequestParam(value = "message", required = false) String message, Model model) {
        if (message != null) {
            model.addAttribute("message", message);
        }
        return "bai-5/home";
    }

    @GetMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "bai-5/home";
    }

    @GetMapping("/c")
    public RedirectView m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return new RedirectView("a");
    }

    @ResponseBody
    @GetMapping("/d")
    public String m4() {
        return "I come from d";
    }
}
