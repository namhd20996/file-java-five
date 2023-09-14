package com.example.lab.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO extends BaseDTO<CategoryDTO> {

    private String id;
    private String name;
    private List<ProductDTO> products;
}
