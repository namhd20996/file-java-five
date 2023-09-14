package com.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/home-page")
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }

    @GetMapping("/bai-4-3")
    public ModelAndView bai_4_3() {
        request.setAttribute("message", "Sử dụng @Autowired");
        return new ModelAndView("bai-4/bai-4-3");
    }

    @GetMapping("/bai-2")
    public ModelAndView bai_2() {
        Map<String, String> map = new HashMap<>();
        map.put("model", "Hello JSP From Controller");
        return new ModelAndView("bai-2/bai-2", map);
    }

    @GetMapping("/bai-4")
    public ModelAndView bai_4() {
        return new ModelAndView("bai-4/bai-4-2");
    }

    @GetMapping("/bai-4-cookie")
    public ModelAndView bai_4_Cookie(HttpServletRequest req) {
        ModelAndView model = new ModelAndView("bai-4/bai-4-2");
        Cookie[] cookies = req.getCookies();
        Map<String, String> map = new HashMap<>();
        for (Cookie cookie : cookies) {
            map.put(cookie.getName(), cookie.getValue());
            System.out.println("Username: " + cookie.getName() + " Password: " + cookie.getValue());
        }
        model.addObject("map", map);
        return model;
    }

    @PostMapping("/bai-4")
    public ModelAndView bai_4(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse resp) {
        Cookie cookie = new Cookie(username, password);
        cookie.setMaxAge(10 * 60 * 60);
        cookie.setPath("/");
        resp.addCookie(cookie);
        Map<String, String> map = new HashMap<>();
        map.put("success", "success");
        return new ModelAndView("bai-4/bai-4-2", map);
    }


}
