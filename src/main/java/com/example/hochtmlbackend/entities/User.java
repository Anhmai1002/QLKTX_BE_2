package com.example.hochtmlbackend.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document(collection = "user")
public class User {
    @Id
    ObjectId id;

    String userId;

    String Name;

    String birthday;

    String gender;

    // String role;

    String address;

    String email;

    String password;

    @CreatedDate
    LocalDateTime createdDate;

    @LastModifiedDate
    LocalDateTime updatedDate;

    // @CreatedBy
    // ObjectId createdBy;
}
