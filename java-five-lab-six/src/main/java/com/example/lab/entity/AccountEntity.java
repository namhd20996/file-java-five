package com.example.lab.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Data
@Entity
@Table(name = "account")
public class AccountEntity implements Serializable {
    @Id
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "email")
    private String email;
    @Column(name = "photo")
    private String photo;
    @Column(name = "activated")
    private boolean activated;
    @OneToMany(mappedBy = "account")
    private List<OrderEntity> orders;
}
