package com.example.labs.controller;

import com.example.labs.service.impl.ShoppingCartServiceImpl;
import com.example.labs.util.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @Autowired
    private DB db;

    @Autowired
    private ShoppingCartServiceImpl cartService;

    @GetMapping("/product")
    public ModelAndView viewProduct() {
        ModelAndView model = new ModelAndView("product");
        model.addObject("models", db.items.values());
        return model;
    }

    @GetMapping("/cart")
    public ModelAndView viewCart() {
        ModelAndView model = new ModelAndView("cart-item");
        model.addObject("carts", cartService.getItems());
        model.addObject("amount", cartService.getAmount());
        model.addObject("count", cartService.getCount());
        return model;
    }


    @GetMapping("/add-product/{id}")
    public ModelAndView addCart(@PathVariable("id") Integer id) {
        cartService.add(id);
        return new ModelAndView("redirect:/shopping-cart/cart");
    }

    @GetMapping("/clear-cart")
    public ModelAndView clearCart(){
        cartService.clear();
        return  new ModelAndView("redirect:/shopping-cart/cart");
    }

    @GetMapping("/remove-cart/{id}")
    public ModelAndView removeCart(@PathVariable("id") Integer id){
        cartService.remove(id);
        return  new ModelAndView("redirect:/shopping-cart/cart");
    }

    @PostMapping("/update-product/{id}")
    public ModelAndView updateCart(@PathVariable("id") Integer id, @RequestParam("qty") Integer qty) {
        cartService.update(id, qty);
        return new ModelAndView("redirect:/shopping-cart/cart");
    }
}
