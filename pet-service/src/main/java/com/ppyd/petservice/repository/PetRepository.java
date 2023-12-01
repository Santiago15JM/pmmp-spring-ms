package com.ppyd.petservice.repository;

import com.ppyd.petservice.models.Pet;
import com.ppyd.petservice.models.Vaccine;
import com.ppyd.petservice.models.dto.ListedPet;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

public interface PetRepository extends MongoRepository<Pet, String> {

    @Aggregation({
            "{$match: {_id: ?0}}",
            "{$lookup: {from:'disease', localField:'diseases', foreignField:'_id', as: 'diseases', pipeline: " +
                    "[{$lookup: {from: 'recommendation', localField: 'recommendations', foreignField: '_id', as: 'recommendations'}}]}}"
    })
    Pet findPetFullInfo(String id);

    @Query("{ownerId: ?0}, {'name': 1, 'type': 1, 'breed': 1, 'sex': 1}")
    ListedPet[] getUserPetList(ObjectId u);

    @Query("{_id: ?0}")
    @Update("{$push: {diseases: ?1}}")
    void addDisease(ObjectId pet, ObjectId disease);

    @Query("{_id: ?0}")
    @Update("{$push: {vaccines: ?1}}")
    void addVaccine(ObjectId pet, Vaccine vaccine);
}

