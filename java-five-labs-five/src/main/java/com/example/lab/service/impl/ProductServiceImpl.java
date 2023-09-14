package com.example.lab.service.impl;

import com.example.lab.converter.ProductConverter;
import com.example.lab.dto.ProductDTO;
import com.example.lab.repository.ProductRepository;
import com.example.lab.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductConverter converter;

    @Override
    public List<ProductDTO> findAll() {
        return converter.toListDTO(repository.findAll());
    }

    @Override
    public List<ProductDTO> findAll(Sort sort) {
        return converter.toListDTO(repository.findAll(sort));
    }

    @Override
    public List<ProductDTO> findAll(Pageable pageable) {
        return converter.toListDTO(repository.findAll(pageable).getContent());
    }

    @Override
    public int count() {
        return repository.findAll().size();
    }
}
