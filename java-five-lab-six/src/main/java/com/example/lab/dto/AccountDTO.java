package com.example.lab.dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountDTO extends BaseDTO<AccountDTO>{
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String photo;
    private boolean activated;
    private List<OrderDTO> orders;
}
