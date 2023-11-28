package com.ppyd.diseaseservice.models.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class DiseaseName {
    @Id
    private String id;
    private String name;
}
