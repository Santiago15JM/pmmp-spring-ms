package com.ppyd.statisticsservice.models.dto;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class DiseaseNameForStats {
    @Id
    private ObjectId id;
    private String name;
}
