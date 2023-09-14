package com.example.lab.converter;

import com.example.lab.dto.CategoryDTO;
import com.example.lab.entity.CategoryEnity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryConverter {

    @Autowired
    private ModelMapper mapper;

    public CategoryEnity toEntity(CategoryDTO dto) {
        CategoryEnity enity = null;
        if (dto != null) {
            enity = mapper.map(dto, CategoryEnity.class);
        }
        return enity;
    }

    public CategoryDTO toDTO(CategoryEnity enity) {
        CategoryDTO dto = null;
        if (enity != null) {
            dto = mapper.map(enity, CategoryDTO.class);
        }
        return dto;
    }

    public List<CategoryEnity> toListEntity(List<CategoryDTO> dtos) {
        List<CategoryEnity> list = Arrays.asList(mapper.map(dtos, CategoryEnity[].class));
        return list;
    }

    public List<CategoryDTO> toListDTO(List<CategoryEnity> enities) {
        List<CategoryDTO> list = Arrays.asList(mapper.map(enities, CategoryDTO[].class));
        return list;
    }
}
