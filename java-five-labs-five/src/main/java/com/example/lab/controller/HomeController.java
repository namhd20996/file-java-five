package com.example.lab.controller;

import com.example.lab.dto.CategoryDTO;
import com.example.lab.entity.CategoryEnity;
import com.example.lab.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/home-page")
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }

    @GetMapping("/bai-2")
    public ModelAndView doGetBai_2(@ModelAttribute("item") CategoryDTO dto,
                                   @RequestParam(value = "message", required = false) String message,
                                   @RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView("bai-2/bai-2");
        List<CategoryDTO> list = categoryService.findAll();
        model.addObject("items", list);
        if (message != null) {
            model.addObject("message", message);
        }
        if (error != null) {
            model.addObject("error", error);
        }
        return model;
    }

    @PostMapping("/bai-2/create")
    public ModelAndView doPostCreBai_2(@ModelAttribute CategoryDTO dto, RedirectAttributes params) {
        ModelAndView model = new ModelAndView("redirect:/bai-2");
        CategoryDTO categoryDTO = categoryService.saveOrUpdate(dto);
        if (categoryDTO != null) {
            params.addAttribute("message", "Create Success");
        } else {
            params.addAttribute("error", "Create Fail");
        }
        return model;
    }

    @PostMapping("/bai-2/update")
    public ModelAndView doPostUpBai_2(@ModelAttribute CategoryDTO dto, RedirectAttributes params) {
        ModelAndView model = new ModelAndView("redirect:/bai-2/edit?id=" + dto.getId());
        CategoryDTO categoryDTO = categoryService.saveOrUpdate(dto);
        if (categoryDTO != null) {
            params.addAttribute("message", "Update Success");
        } else {
            params.addAttribute("error", "Update Fail");
        }
        return model;
    }

    @GetMapping("/bai-2/edit")
    public ModelAndView doGetEdBai_2(@RequestParam("id") String id,
                                     @RequestParam(value = "message", required = false) String message,
                                     @RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView("bai-2/bai-2");
        CategoryDTO dto = categoryService.findOneById(id);
        List<CategoryDTO> list = categoryService.findAll();
        model.addObject("item", dto);
        model.addObject("items", list);
        if (message != null) {
            model.addObject("message", message);
        }
        if (error != null) {
            model.addObject("error", error);
        }
        return model;
    }

    @GetMapping("/bai-2/delete")
    public ModelAndView doGetDeBai_2(@RequestParam(value = "id", required = false) String id) {
        ModelAndView model = new ModelAndView("redirect:/bai-2");
        if (id != null) {
            categoryService.delete(id);
        }
        return model;
    }
}
