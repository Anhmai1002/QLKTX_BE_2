package com.example.hochtmlbackend.entities;

import io.swagger.v3.oas.annotations.Operation;
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
@Document(collection = "contract")
public class Contract {
    @Id
    ObjectId id;

    String contractId;

    String startDay;

    String endDay;

    String studentId;

    String roomId;

    String userId;

    @CreatedDate
    LocalDateTime createdDate;

    @LastModifiedDate
    LocalDateTime updatedDate;

    // @CreatedBy
    // ObjectId createdBy;
}
