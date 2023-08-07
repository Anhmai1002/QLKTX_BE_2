package com.example.hochtmlbackend.repositories;

import com.example.hochtmlbackend.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserId(String AdminId);
}
