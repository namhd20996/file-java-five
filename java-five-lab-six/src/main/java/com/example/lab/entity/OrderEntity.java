package com.example.lab.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "createdate")
    private Date createDate = new Date();
    @ManyToOne
    @JoinColumn(name = "accountid")
    private AccountEntity account;
    @OneToMany(mappedBy = "order")
    private List<OrderDetailEntity> orders;

}
