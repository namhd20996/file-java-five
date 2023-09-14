package com.example.labs.controller;

import com.example.labs.dto.Account;
import com.example.labs.service.IParamService;
import com.example.labs.util.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private DB db;

    @Autowired
    private IParamService paramService;

    private List<Account> list = new ArrayList<>();

    @GetMapping("/views")
    public ModelAndView indexAccount() {
        ModelAndView model = new ModelAndView("view-accounts");
        model.addObject("accounts", list);
        return model;
    }

    @GetMapping("/register")
    public ModelAndView registerGet(@ModelAttribute("account") Account account) {
        return new ModelAndView("register");
    }

    @GetMapping("/delete-account")
    public ModelAndView deleteAccount(@RequestParam("username") String username) {
        int position = db.findAccountByUsername(list, username);
        if (position >= 0) {
            list.remove(position);
        }
        return new ModelAndView("redirect:/account/views");
    }

    @GetMapping("/edit-account")
    public ModelAndView editAccount(@RequestParam("username") String username) {
        ModelAndView model = new ModelAndView("register");
        int position = db.findAccountByUsername(list, username);
        model.addObject("account", list.get(position));
        return model;
    }

    @PostMapping("/register")
    public ModelAndView registerPost(@ModelAttribute("account") Account account, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        ModelAndView model = new ModelAndView("register");
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String uploadDir = servletContext.getRealPath("uploads/");
        int position = db.findAccountByUsername(list, account.getUsername());
        paramService.save(multipartFile, uploadDir, fileName);
        if (position >= 0) {
            account.setPhoto(fileName);
            list.set(position, account);
            System.out.println("Update Success " + account.getUsername());
        } else {
            account.setPhoto(fileName);
            list.add(account);
            System.out.println("Insert Success " + account.getUsername());
        }
        return model;
    }

}
