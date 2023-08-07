package com.example.hochtmlbackend.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
@Data
public class Product {
    @Id
    ObjectId id;

    String productId;

    String name;

    String description;
}
