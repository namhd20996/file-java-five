package com.example.lab.service;

import com.example.lab.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {

    CategoryDTO findOneById(String id);

    List<CategoryDTO> findAll();

    CategoryDTO saveOrUpdate(CategoryDTO dto);

    void delete(String id);

}
