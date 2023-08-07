package com.example.hochtmlbackend.repositories;

import com.example.hochtmlbackend.entities.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, ObjectId> {
    Student findByStudentId(String StudenId);
}
