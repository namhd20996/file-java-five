package com.example.lab.service.impl;

import com.example.lab.converter.ProductConverter;
import com.example.lab.converter.ReportConverter;
import com.example.lab.dto.ProductDTO;
import com.example.lab.dto.ReportDTO;
import com.example.lab.entity.ProductEntity;
import com.example.lab.repository.IProductRepository;
import com.example.lab.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductConverter converter;

    @Autowired
    private ReportConverter reportConverter;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<ProductDTO> findByPrice(double min, double max) {
        return converter.toListDTO(productRepository.findByPrice(min, max));
    }

    @Override
    public Page<ProductEntity> findByKeyword(String keyword, Pageable pageable) {
        Page<ProductEntity> entities = productRepository.findByKeyword(keyword, pageable);
        return entities;
    }

    @Override
    public List<ReportDTO> getInventoryByCategory() {
        return reportConverter.toListDTO(productRepository.getInventoryByCategory());
    }

    @Override
    public List<ProductDTO> findByPriceBetween(double min, double max) {
        return converter.toListDTO(productRepository.findByPriceBetween(min, max));
    }

    @Override
    public List<ProductDTO> findAllByNameLike(String keyword, Pageable pageable) {
        return converter.toListDTO(productRepository.findAllByNameLike(keyword, pageable));
    }

    @Override
    public int count() {
        return productRepository.findAll().size();
    }
}
