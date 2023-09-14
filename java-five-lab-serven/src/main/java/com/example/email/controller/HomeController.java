package com.example.email.controller;

import com.example.email.model.MailModel;
import com.example.email.service.impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MailServiceImpl mailService;

    @GetMapping("/home-page")
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }

    @GetMapping("/bai-3")
    public ModelAndView bai_3() {
        return new ModelAndView("bai-3/home");
    }

    @ResponseBody
    @GetMapping("/bai-1-2")
    public String bai_1_2() {
        mailService.push("namhdps25979@fpt.edu.vn", "Gửi từ Duy Nam", "Hello!... Good Morning!");
        return "Ok";
    }

    @PostMapping("/bai-3")
    public ModelAndView doPostBai_3(@ModelAttribute MailModel mailModel, @RequestParam("attachment") MultipartFile multipartFile) throws Exception {
        ModelAndView model = new ModelAndView("bai-3/home");
        List<File> list = new ArrayList<>();
        File file = mailService.convert(multipartFile);
        list.add(file);
        mailModel.setFiles(list);
        mailService.push(mailModel);
        return model;
    }

    @GetMapping("/bai-4")
    public ModelAndView bai_4() {
        return new ModelAndView("bai-4/home");
    }
}
