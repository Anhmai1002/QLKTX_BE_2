package com.example.hochtmlbackend.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "student")
public class Student {
    @Id
    ObjectId id;

    String studentId;

    String name;

    String gender;

    String address;

    String className;

    String Faculty;

    String numberPhone;

    String userId;

    @CreatedDate
    LocalDateTime createdDate;

    @LastModifiedDate
    LocalDateTime updatedDate;
    // @CreatedBy
    // ObjectId createdBy;
}
