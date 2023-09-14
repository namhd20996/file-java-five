package com.example.lab.repository;

import com.example.lab.entity.ProductEntity;
import com.example.lab.entity.ReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query("SELECT o FROM ProductEntity o WHERE o.price BETWEEN ?1 AND ?2")
    List<ProductEntity> findByPrice(double min, double max);

    @Query("SELECT o FROM ProductEntity o WHERE o.name LIKE ?1")
    Page<ProductEntity> findByKeyword(String keyword, Pageable pageable);

    @Query("SELECT new ReportEntity(o.category, sum(o.price), count(o)) "
            + " FROM ProductEntity o "
            + " GROUP BY o.category"
            + " ORDER BY sum(o.price) DESC")
    List<ReportEntity> getInventoryByCategory();

    List<ProductEntity> findByPriceBetween(double min, double max);

    List<ProductEntity> findAllByNameLike(String keyword, Pageable pageable);
}
