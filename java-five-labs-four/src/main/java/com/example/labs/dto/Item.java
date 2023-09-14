package com.example.labs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private Integer id;
    private  String name;
    private Double price;
    private Integer quantity;
}
