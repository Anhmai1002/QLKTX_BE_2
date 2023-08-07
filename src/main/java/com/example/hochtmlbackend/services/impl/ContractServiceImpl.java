package com.example.hochtmlbackend.services.impl;

import com.example.hochtmlbackend.DTOs.ContractDTO;
import com.example.hochtmlbackend.DTOs.ContractUpdateDTO;
import com.example.hochtmlbackend.entities.User;
import com.example.hochtmlbackend.entities.Contract;
import com.example.hochtmlbackend.repositories.UserRepository;
import com.example.hochtmlbackend.repositories.ContractRepository;
import com.example.hochtmlbackend.repositories.RoomRepository;
import com.example.hochtmlbackend.services.ContractService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;


    @Override
    public void create(ContractDTO dto ){
        Contract contract = new Contract();
        SecureRandom random = new SecureRandom();
        contract.setContractId(String.format("%04d", random.nextInt(10000)));
        contract.setRoomId(dto.getRoomId());
        contract.setStartDay(dto.getStartDay());
        contract.setEndDay(dto.getEndDay());
        contract.setStudentId(dto.getStudentId());
        contract.setCreatedDate(LocalDateTime.now());
        contract.setUserId(dto.getUserId());
        contractRepository.save(contract);
    }

    @Override
    public List<ContractDTO> list() {
        List<Contract> listData = contractRepository.findAll();
        List<ContractDTO> response = new ArrayList<>();
        for (Contract dto : listData) {
            ContractDTO contract = new ContractDTO();
            contract.setContractId(dto.getContractId());
            contract.setRoomId(dto.getRoomId());
            contract.setStartDay(dto.getStartDay());
            contract.setEndDay(dto.getEndDay());
            contract.setStudentId(dto.getStudentId());
            contract.setUserId(dto.getUserId());
            response.add(contract);
        }
        return response;
    }

    @Override
    public ContractDTO info(String contractId) {
        Contract data = contractRepository.findByContractId(contractId);
        ContractDTO dto = new ContractDTO();
        dto.setContractId(data.getContractId());
        dto.setRoomId(data.getRoomId());
        dto.setStartDay(data.getStartDay());
        dto.setEndDay(data.getEndDay());
        dto.setStudentId(data.getStudentId());
        dto.setUserId(dto.getUserId());
        return dto;
    }

    @Override
    public void delete(String contractId ) {
        Contract data = contractRepository.findByContractId(contractId);
        contractRepository.delete(data);
    }

    @Override
    public void update(String id, ContractUpdateDTO dto ) {
        Contract data = contractRepository.findByContractId(id);
        data.setRoomId(dto.getRoomId());
        data.setStartDay(dto.getStartDay());
        data.setEndDay(dto.getEndDay());
        data.setStudentId(dto.getStudentId());
        data.setCreatedDate(LocalDateTime.now());
        data.setUserId(dto.getUserId());
        contractRepository.save(data);
    }
}
