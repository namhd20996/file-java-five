package com.example.lab.controller;

import com.example.lab.dto.ProductDTO;
import com.example.lab.dto.ReportDTO;
import com.example.lab.entity.ProductEntity;
import com.example.lab.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private IProductService productService;

    @Autowired
    private HttpSession session;

    @GetMapping("/home-page")
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }

    @GetMapping("bai-1")
    public ModelAndView bai_1(@RequestParam("min") Optional<Double> min,
                              @RequestParam("max") Optional<Double> max) {
        ModelAndView model = new ModelAndView("bai-1/home");
        List<ProductDTO> list = productService.findByPrice(min.orElse(Double.MIN_VALUE), max.orElse(Double.MAX_VALUE));
        model.addObject("items", list);
        return model;
    }

    @GetMapping("/bai-2")
    public ModelAndView bai_2(@RequestParam("keyword") Optional<String> kw,
                              @RequestParam("p") Optional<Integer> p
//                              @RequestParam("page") Optional<Integer> page
//                              @RequestParam("limit") Optional<Integer> limit
    ) {
        ModelAndView model = new ModelAndView("bai-2/home");
//        ProductDTO dto = new ProductDTO();
//        dto.setPage(page.orElse(0) == 0 ? page.orElse(0) : page.orElse(0) - 1);
//        dto.setLimit(limit.orElse(2));
//        dto.setTotalItem(productService.count());
//        dto.setTotalPage((int) Math.ceil((double) dto.getTotalItem() / dto.getLimit()));
        String keywords = kw.orElse(session.getAttribute("keywords") + "");
        session.setAttribute("keywords", keywords);
//        Pageable pageable = PageRequest.of(page.orElse(0) == 0 ? page.orElse(0) : page.orElse(0) - 1, limit.orElse(2));
        Pageable pageable = PageRequest.of(p.orElse(0), 2);
        Page<ProductEntity> list = productService.findByKeyword(keywords, pageable);
        model.addObject("items", list);
//        model.addObject("model", dto);
        return model;
    }

    @GetMapping("/bai-3")
    public ModelAndView bai_3() {
        ModelAndView model = new ModelAndView("bai-3/home");
        List<ReportDTO> list = productService.getInventoryByCategory();
        model.addObject("items", list);
        return model;
    }

    @GetMapping("/bai-4")
    public ModelAndView bai_4(@RequestParam("min") Optional<Double> min,
                              @RequestParam("max") Optional<Double> max) {
        ModelAndView model = new ModelAndView("bai-4/home");
        model.addObject("items",
                productService.findByPriceBetween(min.orElse(Double.MIN_VALUE),
                        max.orElse(Double.MAX_VALUE)));
        return model;
    }

    @GetMapping("/bai-5")
    public ModelAndView bai_5(@RequestParam("keyword") Optional<String> kw,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("limit") Optional<Integer> limit) {
        ModelAndView model = new ModelAndView("bai-5/home");
        String keywords = kw.orElse(session.getAttribute("keywords") + "");
        session.setAttribute("keywords", keywords);
        ProductDTO dto = new ProductDTO();
        dto.setPage(page.orElse(1));
        dto.setLimit(limit.orElse(2));
        dto.setTotalItem(productService.count());
        dto.setTotalPage((int) Math.ceil((double) dto.getTotalItem() / dto.getLimit()));
        Pageable pageable = PageRequest.of(dto.getPage() - 1, dto.getLimit());
        List<ProductDTO> list = productService.findAllByNameLike(keywords, pageable);
        model.addObject("model", dto);
        model.addObject("items", list);
        return model;
    }
}
