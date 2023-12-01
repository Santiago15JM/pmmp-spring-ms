package com.ppyd.petservice.repository;

import com.ppyd.petservice.models.Breed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BreedRepository extends MongoRepository<Breed, String> {
    @Query(value = "{type: ?0}", fields = "{name: 1}", sort = "{name: 1}")
    List<Breed> getBreedsOfType(String type);
}
