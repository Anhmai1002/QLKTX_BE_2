package com.example.hochtmlbackend.repositories;

import com.example.hochtmlbackend.entities.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {
    Product findProductById(ObjectId id);

    Product findProductByProductId(String productId);
}
