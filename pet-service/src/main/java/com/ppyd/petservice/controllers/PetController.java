package com.ppyd.petservice.controllers;

import com.ppyd.petservice.models.Breed;
import com.ppyd.petservice.models.Pet;
import com.ppyd.petservice.models.Vaccine;
import com.ppyd.petservice.models.dto.AddDiseaseDTO;
import com.ppyd.petservice.models.dto.AddVaccineDTO;
import com.ppyd.petservice.models.dto.ListedPet;
import com.ppyd.petservice.repository.BreedRepository;
import com.ppyd.petservice.repository.PetRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pets")
public class PetController {
    @Autowired
    PetRepository petRepo;
    @Autowired
    BreedRepository breedRepo;

    @PostMapping("/addPet")
    public void registerPet(@RequestBody Pet pet) {
        petRepo.save(pet);
    }

    @GetMapping("/getPet")
    public Pet getPet(@RequestParam String id) {
        Pet pet = petRepo.findPetFullInfo(id);
        if (pet == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        return pet;
    }

    @GetMapping("/getUserPets")
    ListedPet[] getUserPets(@RequestParam ObjectId u) {
        return petRepo.getUserPetList(u);
    }

    @PostMapping("/addDisease")
    void addDisease(@RequestBody AddDiseaseDTO dto) {
        petRepo.addDisease(dto.getPet(), dto.getDisease());
    }

    @PostMapping("/addVaccine")
    void addVaccine(@RequestBody AddVaccineDTO dto) {
        petRepo.addVaccine(dto.getPet(), dto.getVaccine());
    }

    @GetMapping("/getBreeds")
    List<String> getBreeds(@RequestParam String type) {
        List<Breed> breeds = breedRepo.getBreedsOfType(type);
        return breeds.stream().map(Breed::getName).collect(Collectors.toList());
    }

}
