package com.example.lab.converter;

import com.example.lab.dto.ProductDTO;
import com.example.lab.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductConverter {

    @Autowired
    private ModelMapper mapper;

    public ProductEntity toEntity(ProductDTO dto) {
        ProductEntity entity = null;
        if (dto != null) {
            entity = mapper.map(dto, ProductEntity.class);
        }
        return entity;
    }

    public ProductDTO toDTO(ProductEntity entity) {
        ProductDTO dto = null;
        if (entity != null) {
            dto = mapper.map(entity, ProductDTO.class);
        }
        return dto;
    }

    public List<ProductEntity> toListEntity(List<ProductDTO> dtos) {
        List<ProductEntity> list = Arrays.asList(mapper.map(dtos, ProductEntity[].class));
        return list;
    }

    public List<ProductDTO> toListDTO(List<ProductEntity> entities) {
        List<ProductDTO> list = Arrays.asList(mapper.map(entities, ProductDTO[].class));
        return list;
    }
}
