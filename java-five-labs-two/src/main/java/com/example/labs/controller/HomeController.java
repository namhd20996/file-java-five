package com.example.labs.controller;

import com.example.labs.dto.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home-page")
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }

    @GetMapping("/bai-1")
    public ModelAndView bai_1() {
        return new ModelAndView("/bai-1/home");
    }

    @GetMapping("/bai-2")
    public ModelAndView bai_2() {
        return new ModelAndView("/bai-2/home");
    }

    @GetMapping("/bai-3")
    public ModelAndView bai_3() {
        return new ModelAndView("/bai-3/home");
    }

    @GetMapping("/ctrl/ok")
    public String m2(ModelMap model) {
        model.addAttribute("x", "Method 2");
        return "bai-1/home";
    }

    @PostMapping("/ctrl/ok")
    public String m1(@RequestParam(value = "x", required = false) String x, ModelMap model) {
        model.addAttribute("x", "Method 1");
        if (x != null) {
            model.addAttribute("x", "Method 3");
        }
        return "bai-1/home";
    }

    @PostMapping("/bai-2/{x}")
    public ModelAndView bai_2(@RequestParam("y") String y, @PathVariable("x") String x) {
        ModelAndView model = new ModelAndView("bai-2/home");
        model.addObject("x", x);
        model.addObject("y", y);
        return model;
    }

    @PostMapping("/bai-3")
    public ModelAndView bai_3(@RequestParam("name") String name, @RequestParam("price") Double price) {
        ModelAndView model = new ModelAndView("/bai-3/home");
        Product product = new Product(name, price);
        model.addObject("model", product);
        return model;
    }

}
