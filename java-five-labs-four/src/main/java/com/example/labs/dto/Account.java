package com.example.labs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String photo;
    private Boolean activated;
    private Boolean admin;
}
