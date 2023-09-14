package com.example.lab.repository;

import com.example.lab.entity.CategoryEnity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEnity, String> {
}
