package com.example.email.controller;

import com.example.email.constant.SystemConstant;
import com.example.email.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final HttpSession session;

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("bai-5/login");
    }

    @PostMapping("/login")
    public ModelAndView doPostLoginPage(@ModelAttribute UserModel userModel) {
        ModelAndView model = new ModelAndView();
        if (userModel.getUsername().equals("sellsad") && userModel.getPassword().equals("123")) {
            String uri = (String) session.getAttribute(SystemConstant.URI_SESSION);
            if (uri != null) {
                model.setViewName("redirect:" + uri);
            } else {
                userModel.setAdmin(true);
                session.setAttribute(SystemConstant.USER_SESSION, userModel);
            }
        } else {
            model.addObject("message", "Invalid username or password");

        }
        model.setViewName("bai-5/login");
        return model;
    }
}
