package com.ppyd.petservice.models.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class AddDiseaseDTO {
    private ObjectId pet;
    private ObjectId disease;
}
