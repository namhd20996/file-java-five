package com.example.labs.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class BaseDTO<T> {
    private Long id;
    private Date createdDate;
    private Date lastmodifiedDate;
    private String createdBy;
    private String lastmodifiedBy;
    private Long[] ids;
    private List<T> listResult = new ArrayList<>();
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
