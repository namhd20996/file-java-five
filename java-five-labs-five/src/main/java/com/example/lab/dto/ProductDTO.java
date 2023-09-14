package com.example.lab.dto;

import com.example.lab.entity.CategoryEnity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProductDTO extends BaseDTO<ProductDTO>{
    private Integer id;
    private String name;
    private String image;
    private Double price;
    private Date createDate = new Date();
    private Boolean available;
    private CategoryEnity category;
    private List<OrderDetailDTO> orderDetails;
}
