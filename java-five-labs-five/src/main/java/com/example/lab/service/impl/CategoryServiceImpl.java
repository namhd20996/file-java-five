package com.example.lab.service.impl;

import com.example.lab.converter.CategoryConverter;
import com.example.lab.dto.CategoryDTO;
import com.example.lab.entity.CategoryEnity;
import com.example.lab.repository.CategoryRepository;
import com.example.lab.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository category;

    @Autowired
    private CategoryConverter converter;

    @Override
    public CategoryDTO findOneById(String id) {
        CategoryEnity enity = category.findById(id).get();
        return converter.toDTO(enity);
    }

    @Override
    public List<CategoryDTO> findAll() {
        return converter.toListDTO(category.findAll());
    }

    @Override
    @Transactional
    public CategoryDTO saveOrUpdate(CategoryDTO dto) {
        if (dto.getId().equals("")) {
            return null;
        }
        CategoryEnity enity = converter.toEntity(dto);
        return converter.toDTO(category.save(enity));
    }

    @Override
    @Transactional
    public void delete(String id) {
        category.deleteById(id);
    }
}
