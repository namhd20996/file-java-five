package com.example.lab.converter;

import com.example.lab.dto.ReportDTO;
import com.example.lab.entity.ReportEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ReportConverter {

    @Autowired
    private ModelMapper mapper;

    public ReportEntity toEntity(ReportDTO dto) {
        ReportEntity entity = null;
        if (dto != null) {
            entity = mapper.map(dto, ReportEntity.class);
        }
        return entity;
    }

    public ReportDTO toDTO(ReportEntity entity) {
        ReportDTO dto = null;
        if (entity != null) {
            dto = mapper.map(entity, ReportDTO.class);
        }
        return dto;
    }

    public List<ReportEntity> toListEntity(List<ReportDTO> dtos) {
        List<ReportEntity> entities = Arrays.asList(mapper.map(dtos, ReportEntity[].class));
        return entities;
    }

    public List<ReportDTO> toListDTO(List<ReportEntity> entities) {
        List<ReportDTO> dtos = Arrays.asList(mapper.map(entities, ReportDTO[].class));
        return dtos;
    }
}
