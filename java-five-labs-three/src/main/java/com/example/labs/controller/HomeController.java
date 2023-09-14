package com.example.labs.controller;

import com.example.labs.entity.Student;
import com.example.labs.entity.StudentTwo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/home-page")
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }

    @GetMapping("/bai-1")
    public ModelAndView bai_1(@ModelAttribute("student") Student student) {
        return new ModelAndView("bai-1/home");
    }

    @GetMapping("/bai-2")
    public ModelAndView bai_2(@ModelAttribute("student") Student student) {
        return new ModelAndView("bai-2/home");
    }

    @GetMapping("/bai-5")
    public ModelAndView bai_5(@ModelAttribute("sv") Student student) {
        return new ModelAndView("bai-5/home");
    }

    @PostMapping("/bai-1")
    public ModelAndView bai_1_Save(@ModelAttribute("student") Student student) {
        return new ModelAndView("bai-1/home");
    }

    @PostMapping(value = "/bai-2")
    public ModelAndView bai_2_Save(@Validated @ModelAttribute("student") Student student, BindingResult result) {
        ModelAndView model = new ModelAndView("bai-2/home");
        if (result.hasErrors()) {
            model.addObject("message", "Vui lòng sửa các lỗi sau");
        } else {
            model.addObject("message", "Chúc mừng, bạn đã nhập đúng");
        }
        return model;
    }

    @PostMapping("/bai-5")
    public ModelAndView bai_5_Save(@Validated @ModelAttribute("sv") StudentTwo student, BindingResult result) {
        ModelAndView model = new ModelAndView("bai-5/home");
        if (result.hasErrors()) {
            model.addObject("message", "Vui lòng sửa các lỗi sau");
        } else {
            model.addObject("message", "Chúc mừng, bạn đã nhập đúng");
        }
        return model;
    }

    @ModelAttribute("listGender")
    public Map<Boolean, String> getListGender() {
        Map<Boolean, String> map = new HashMap<>();
        map.put(true, "Male");
        map.put(false, "FeMale");
        return map;
    }

    @ModelAttribute("listFaculties")
    public List<String> getListFaculties() {
        return Arrays.asList("CNTT", "DLNHKS", "QTDN");
    }

    @ModelAttribute("listHobbie")
    public Map<String, String> getMapHobbies() {
        Map<String, String> map = new HashMap<>();
        map.put("T", "Travelling");
        map.put("M", "Music");
        map.put("F", "Food");
        map.put("O", "Other");
        return map;
    }
}
