package com.example.hochtmlbackend.repositories;

import com.example.hochtmlbackend.entities.Contract;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends MongoRepository<Contract, ObjectId> {
    Contract findByContractId(String ContractId);
}
