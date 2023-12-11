package com.ppyd.diseaseservice.controllers;

import com.ppyd.diseaseservice.models.dto.DiseaseName;
import com.ppyd.diseaseservice.services.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Controller
public class GraphQLController {
    @Autowired
    private DiseaseService diseaseService;

    @QueryMapping
    public DiseaseName[] allDisease(@Argument String type) {
        return diseaseService.getAllDiseases(type);
    }

}
