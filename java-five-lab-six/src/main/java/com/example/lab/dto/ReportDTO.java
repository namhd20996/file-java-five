package com.example.lab.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReportDTO extends BaseDTO<ReportDTO> {

    private Serializable group;
    private Double sum;
    private Long count;
}
