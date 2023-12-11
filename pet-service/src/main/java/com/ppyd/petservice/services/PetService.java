package com.ppyd.petservice.services;

import com.ppyd.petservice.models.Breed;
import com.ppyd.petservice.models.Pet;
import com.ppyd.petservice.models.dto.AddDiseaseDTO;
import com.ppyd.petservice.models.dto.AddVaccineDTO;
import com.ppyd.petservice.models.dto.ListedPet;
import com.ppyd.petservice.repository.BreedRepository;
import com.ppyd.petservice.repository.PetRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepo;
    @Autowired
    private BreedRepository breedRepo;

    public void registerPet(@RequestBody Pet pet) {
        petRepo.save(pet);
    }

    public Pet getPet(@RequestParam String id) {
        Pet pet = petRepo.findPetFullInfo(id);
        if (pet == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        return pet;
    }

    public ListedPet[] getUserPets(@RequestParam ObjectId u) {
        return petRepo.getUserPetList(u);
    }

    public void addDisease(@RequestBody AddDiseaseDTO dto) {
        petRepo.addDisease(dto.getPet(), dto.getDisease());
    }

    public void addVaccine(@RequestBody AddVaccineDTO dto) {
        petRepo.addVaccine(dto.getPet(), dto.getVaccine());
    }

    public List<String> getBreeds(@RequestParam String type) {
        List<Breed> breeds = breedRepo.getBreedsOfType(type);
        return breeds.stream().map(Breed::getName).collect(Collectors.toList());
    }
}
