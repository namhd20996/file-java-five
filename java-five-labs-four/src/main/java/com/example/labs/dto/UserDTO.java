package com.example.labs.dto;

import lombok.Data;

@Data
public class UserDTO extends BaseDTO<UserDTO> {

    private String username;
    private String password;
    private Boolean remember;
}
