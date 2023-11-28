package com.ppyd.statisticsservice.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Pet {
    @Id
    private String id;
    private String ownerId;
    private String name;
    private String type;
    private String breed;
    private String sex;
    private int age;
    private Disease[] diseases;
    private Vaccine[] vaccines;
}
