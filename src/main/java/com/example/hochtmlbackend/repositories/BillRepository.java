package com.example.hochtmlbackend.repositories;

import com.example.hochtmlbackend.entities.Bill;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends MongoRepository<Bill, ObjectId> {
    Bill findByBillId(String BillId);
}
