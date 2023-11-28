package com.ppyd.statisticsservice.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Recommendation {
    @Id
    private String id;
    private String description;
}
