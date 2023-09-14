package com.example.lab.dto;

import com.example.lab.entity.AccountEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO extends BaseDTO<OrderDTO> {
    private Long id;
    private String address;
    private Date createDate = new Date();
    private AccountEntity account;
    private List<OrderDetailDTO> orders;

}
