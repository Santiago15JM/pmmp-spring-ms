package com.ppyd.diseaseservice.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Disease {
    @Id
    private String id;
    private String name;
    private String description;
    private Recommendation[] recommendations;
    private String[] animaltypes;
}
