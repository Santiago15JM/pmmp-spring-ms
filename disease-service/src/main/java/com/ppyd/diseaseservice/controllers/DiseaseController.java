package com.ppyd.diseaseservice.controllers;

import com.ppyd.diseaseservice.models.dto.DiseaseName;
import com.ppyd.diseaseservice.repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController
////@CrossOrigin(origins = "*")
////@RequestMapping(path = "/diseases")
//public class DiseaseController {
//
//    @Autowired
//    DiseaseRepository diseaseRepo;
//
//    @GetMapping
//    DiseaseName[] getAllDiseases(@RequestParam String type) {
//        return diseaseRepo.getAllDiseases(type);
//    }
//}
