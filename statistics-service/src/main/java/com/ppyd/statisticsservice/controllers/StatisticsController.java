package com.ppyd.statisticsservice.controllers;

import com.ppyd.statisticsservice.models.Pet;
import com.ppyd.statisticsservice.models.Summary;
import com.ppyd.statisticsservice.models.SummaryEntry;
import com.ppyd.statisticsservice.models.dto.DiseaseNameForStats;
import com.ppyd.statisticsservice.models.dto.PetForStats;
import com.ppyd.statisticsservice.repository.DiseaseRepository;
import com.ppyd.statisticsservice.repository.PetRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@RestController
//@CrossOrigin("*")
@RequestMapping("/stats")
public class StatisticsController {

    @Autowired
    PetRepository petRepo;
    @Autowired
    DiseaseRepository diseaseRepo;

    @GetMapping("/getPublicStatus")
    public List<Summary> getPublicStatus(@RequestParam ObjectId user) {
        var status = new LinkedList<Summary>();
        var types = petRepo.getOwnedTypes(user); // TODO Optimize to avoid matching dogs with cat breeds
        var breeds = petRepo.getOwnedBreeds(user);

        System.err.println("TYPES " + types.length);
        System.err.println("BREEDS " + breeds.length);

        for (String type : types) {
            for (String breed : breeds) {
                var summary = new Summary(type, breed);

                var pets = petRepo.getAllPetsForStatsOfTypeBreed(type, breed);
                for (PetForStats pet : pets) {
                    for (DiseaseNameForStats curDisease : pet.getDiseases()) {
                        if (summary.getEntries().stream().anyMatch(e -> e.getDisease().equals(curDisease.getName())))
                            continue;

//                        var petsWithDisease = Arrays.stream(pets).filter(p -> Arrays.stream(p.getDiseases()).anyMatch(d -> d.getId() == curDisease.getId()));
                        var petsWithDisease = Arrays.stream(pets).filter(p -> {
                            var dis = Arrays.stream(p.getDiseases()).filter(d -> d.getName().equals(curDisease.getName()));
                            return dis.findAny().isPresent();
                        });

                        var count = petsWithDisease.count();
                        var percentage = (int) count * 100 / pets.length;
                        var recommendations = diseaseRepo.getRecommendationsForDisease(curDisease.getId());

                        var entry = new SummaryEntry(curDisease.getName(), percentage, recommendations);
                        summary.addEntry(entry);
                    }
                }

                if (!summary.getEntries().isEmpty()) status.addLast(summary);
            }
        }

        return status;
    }

}
