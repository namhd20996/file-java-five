package com.example.lab.service;

import com.example.lab.dto.ProductDTO;
import com.example.lab.dto.ReportDTO;
import com.example.lab.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    List<ProductDTO> findByPrice(double min, double max);

    Page<ProductEntity> findByKeyword(String keyword, Pageable pageable);

    List<ReportDTO> getInventoryByCategory();

    List<ProductDTO> findByPriceBetween(double min, double max);

    List<ProductDTO> findAllByNameLike(String keyword, Pageable pageable);

    int count();
}
