package com.ppyd.petservice.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Pet {
    @Id
    private String id;
    private ObjectId ownerId;
    private String name;
    private String type;
    private String breed;
    private String sex;
    private int age;
    private Disease[] diseases;
    private Vaccine[] vaccines;
}
