package com.ppyd.diseaseservice.controllers;

import com.ppyd.diseaseservice.models.dto.DiseaseName;
import com.ppyd.diseaseservice.repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@Controller
public class GraphQLController {
    @Autowired
    DiseaseRepository diseaseRepository;

    @QueryMapping
    public DiseaseName[] allDisease(@Argument String type) {
        return diseaseRepository.getAllDiseases(type);
    }

}
