package com.example.lab.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "price")
    private Double price;
    @Column(name = "createdate")
    private Date createDate = new Date();
    @Column(name = "available")
    private Boolean available;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private CategoryEnity category;
    @OneToMany(mappedBy = "product")
    private List<OrderDetailEntity> orderDetails;

}
