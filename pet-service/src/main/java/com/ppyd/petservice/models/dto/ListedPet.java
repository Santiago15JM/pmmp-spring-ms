package com.ppyd.petservice.models.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ListedPet {
    @Id
    private String id;
    private String name;
    private String type;
    private String breed;
    private String sex;
}
