package com.ppyd.petservice.controllers;

import com.ppyd.petservice.models.Pet;
import com.ppyd.petservice.models.dto.AddDiseaseDTO;
import com.ppyd.petservice.models.dto.AddVaccineDTO;
import com.ppyd.petservice.models.dto.ListedPet;
import com.ppyd.petservice.services.PetService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping("/addPet")
    public void registerPet(@RequestBody Pet pet) {
        petService.registerPet(pet);
    }

    @GetMapping("/getPet")
    public Pet getPet(@RequestParam String id) {
        return petService.getPet(id);
    }

    @GetMapping("/getUserPets")
    ListedPet[] getUserPets(@RequestParam ObjectId u) {
        return petService.getUserPets(u);
    }

    @PostMapping("/addDisease")
    void addDisease(@RequestBody AddDiseaseDTO dto) {
        petService.addDisease(dto);
    }

    @PostMapping("/addVaccine")
    void addVaccine(@RequestBody AddVaccineDTO dto) {
        petService.addVaccine(dto);
    }

    @GetMapping("/getBreeds")
    List<String> getBreeds(@RequestParam String type) {
        return petService.getBreeds(type);
    }

}
