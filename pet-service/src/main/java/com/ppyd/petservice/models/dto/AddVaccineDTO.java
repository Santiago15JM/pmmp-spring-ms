package com.ppyd.petservice.models.dto;

import com.ppyd.petservice.models.Vaccine;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class AddVaccineDTO {
    ObjectId pet;
    Vaccine vaccine;
}
