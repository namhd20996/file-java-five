package com.example.lab.service;

import com.example.lab.dto.ProductDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IProductService {

    List<ProductDTO> findAll();

    List<ProductDTO> findAll(Sort sort);

    List<ProductDTO> findAll(Pageable pageable);

    int count();
}
