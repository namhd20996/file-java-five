package com.example.lab.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "orderdetail")
public class OrderDetailEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "productid")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "orderid")
    private OrderEntity order;

}
