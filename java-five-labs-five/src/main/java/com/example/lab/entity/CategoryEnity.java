package com.example.lab.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "category")
public class CategoryEnity implements Serializable {

    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;

}
