package com.ppyd.diseaseservice.services;

import com.ppyd.diseaseservice.models.dto.DiseaseName;
import com.ppyd.diseaseservice.repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

@Service
public class DiseaseService {
    @Autowired
    private DiseaseRepository diseaseRepository;

    public DiseaseName[] getAllDiseases(@Argument String type) {
        return diseaseRepository.getAllDiseases(type);
    }
}
