package com.ppyd.statisticsservice.repository;

import com.ppyd.statisticsservice.models.Pet;
import com.ppyd.statisticsservice.models.dto.PetForStats;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends MongoRepository<Pet, String> {

    @Aggregation({
            "{$match: {_id: ?0}}",
            "{$lookup: {from:'disease', localField:'diseases', foreignField:'_id', as: 'diseases', pipeline: " +
                    "[{$lookup: {from: 'recommendation', localField: 'recommendations', foreignField: '_id', as: 'recommendations'}}]}}"
    })
    Pet findPetFullInfo(String id);

    @Aggregation({"{$match: {type: ?0, breed: ?1}}", "{$lookup: {from:'disease', localField:'diseases', foreignField:'_id', as: 'diseases'}}"})
    PetForStats[] getAllPetsForStatsOfTypeBreed(String type, String breed);

    @Aggregation({"{$match: {ownerId: ?0}}", "{$group: {_id: '$type'}}"})
    String[] getOwnedTypes(ObjectId owner);

    @Aggregation({"{$match: {ownerId: ?0}}", "{$group: {_id: '$breed'}}"})
    String[] getOwnedBreeds(ObjectId owner);

}

