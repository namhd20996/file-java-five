package com.example.lab.repository;

import com.example.lab.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {
}
