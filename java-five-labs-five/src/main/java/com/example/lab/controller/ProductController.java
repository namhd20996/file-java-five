package com.example.lab.controller;

import com.example.lab.dto.ProductDTO;
import com.example.lab.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/bai-3")
    public ModelAndView doGetPro() {
        ModelAndView model = new ModelAndView("bai-3/bai-3");
        List<ProductDTO> list = productService.findAll();
        model.addObject("items", list);
        return model;
    }

    @GetMapping("/bai-4")
    public ModelAndView doGetBai_4(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                   @RequestParam(name = "limit", required = false, defaultValue = "2") Integer limit,
                                   @RequestParam("field") Optional<String> field) {
        ModelAndView model = new ModelAndView("bai-4/bai-4");
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(field.orElse("price")));
        ProductDTO dto = new ProductDTO();
        dto.setPage(page);
        dto.setLimit(limit);
        dto.setTotalItem(productService.count());
        dto.setTotalPage((int) Math.ceil((double) dto.getTotalItem() / dto.getLimit()));
        dto.setResults(productService.findAll(pageable));
        dto.setMessage(field.orElse("price").toUpperCase());
        model.addObject("model", dto);
        return model;
    }

    @GetMapping("/bai-3/sort")
    public ModelAndView doGetSort(@RequestParam("field") Optional<String> field) {
        ModelAndView model = new ModelAndView("bai-3/bai-3");
        model.addObject("field", field.orElse("price").toUpperCase());
        Sort sort = Sort.by(field.orElse("price")).descending();
//      Sort sort = Sort.by(Sort.Direction.DESC, field.orElse("price"));
        model.addObject("items", productService.findAll(sort));
        return model;
    }

}
