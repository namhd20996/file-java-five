package com.example.lab.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class BaseDTO<T> {

//    private Long id;
    private Date createdDate;
    private Date lastModifiedDate;
    private String createdBy;
    private String lastModifiedBy;
//    private Long[] ids;
    private List<T> results = new ArrayList<>();
    private Integer page;
    private Integer limit;
    private Integer totalPage;
    private Integer totalItem;
    private String sortName;
    private String sortBy;
    private String alert;
    private String message;
    private String type;

}
