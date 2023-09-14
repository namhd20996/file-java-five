package com.example.labs.controller;

import com.example.labs.dto.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/product/form")
    public ModelAndView getProduct(RedirectAttributes params) {
        ModelAndView model = new ModelAndView("bai-4/home");
        Product product = new Product("Iphone 30", 5000.0);
        model.addObject("model", product);
        return model;
    }

    @PostMapping("/product/save")
    public ModelAndView getProductTwo(@ModelAttribute("product") Product product) {
        return new ModelAndView("bai-4/home");
    }

    @ModelAttribute("items")
    public List<Product> getItem() {
        return Arrays.asList(new Product("A", 1.0), new Product("B", 12.0));
    }
}
