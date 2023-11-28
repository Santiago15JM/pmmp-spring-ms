package com.ppyd.statisticsservice.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Vaccine {
    @Id
    private String id;
    private String name;
    private String description;
    private Date date;
    private int validity;
}
