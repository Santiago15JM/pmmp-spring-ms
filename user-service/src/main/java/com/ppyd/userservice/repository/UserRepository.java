package com.ppyd.userservice.repository;

import com.ppyd.userservice.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{email: ?0, password: ?1}, {_id: 1}")
    User loginUser(String email, String password);
}