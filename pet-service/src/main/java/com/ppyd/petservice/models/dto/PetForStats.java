package com.ppyd.petservice.models.dto;

import com.ppyd.petservice.models.Vaccine;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PetForStats {
    @Id
    private String id;
    private String type;
    private String breed;
    private String sex;
    private int age;
    private DiseaseNameForStats[] diseases;
    private Vaccine[] vaccines;
}
