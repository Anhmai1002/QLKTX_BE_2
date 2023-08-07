package com.example.hochtmlbackend.services;



import com.example.hochtmlbackend.DTOs.ContractDTO;
import com.example.hochtmlbackend.DTOs.ContractUpdateDTO;

import java.io.IOException;
import java.util.List;

public interface ContractService {
    void create(ContractDTO dto );

    List<ContractDTO> list();

    ContractDTO info(String contractId );

    void delete(String contractId);

    void update(String id, ContractUpdateDTO dto);
}
