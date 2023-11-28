package com.ppyd.petservice.repository;

import com.ppyd.petservice.models.Pet;
import com.ppyd.petservice.models.dto.ListedPet;
import com.ppyd.petservice.models.dto.PetForStats;
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

    @Aggregation({"{$match: {type: ?0, breed: ?1}}", "{$lookup: {from:'disease', localField:'diseases', foreignField:'_id', as: 'diseases'}}"})
    PetForStats[] getAllPetsForStatsOfTypeBreed(String type, String breed);

    @Query("{ownerId: ?0}, {'name': 1, 'type': 1, 'breed': 1, 'sex': 1}")
    ListedPet[] getUserPetList(ObjectId u);

    @Aggregation({"{$match: {ownerId: ?0}}", "{$group: {_id: '$type'}}"})
    String[] getOwnedTypes(ObjectId owner);

    @Aggregation({"{$match: {ownerId: ?0}}", "{$group: {_id: '$breed'}}"})
    String[] getOwnedBreeds(ObjectId owner);

    @Query("{_id: ?0}")
    @Update("{$push: {diseases: ?1}}")
    void addDisease(ObjectId pet, ObjectId disease);
}

