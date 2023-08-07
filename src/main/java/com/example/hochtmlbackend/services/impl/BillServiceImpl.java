package com.example.hochtmlbackend.services.impl;

import com.example.hochtmlbackend.DTOs.BillDTO;
import com.example.hochtmlbackend.DTOs.BillUpdateDTO;
import com.example.hochtmlbackend.entities.User;
import com.example.hochtmlbackend.entities.Bill;
import com.example.hochtmlbackend.repositories.UserRepository;
import com.example.hochtmlbackend.repositories.BillRepository;
import com.example.hochtmlbackend.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class BillServiceImpl implements BillService {
    @Autowired
    BillRepository billRepository;



    @Override
    public void create(BillDTO dto ) {
        Bill bill = new Bill();
        SecureRandom random = new SecureRandom();
        bill.setBillId(String.format("%04d", random.nextInt(10000)));
        bill.setStudentId(dto.getStudentId());
        bill.setPrice(dto.getPrice());
        bill.setCreatedDate(LocalDateTime.now());
        bill.setUserId(dto.getUserId());
        billRepository.save(bill);
    }

    @Override
    public List<BillDTO> list() {
        List<Bill> listData = billRepository.findAll();
        List<BillDTO> response = new ArrayList<>();
        for (Bill dto : listData) {
            BillDTO bill = new BillDTO();
            bill.setBillId(dto.getBillId());
            bill.setStudentId(dto.getStudentId());
            bill.setPrice(dto.getPrice());
            bill.setUserId(dto.getUserId());
            response.add(bill);
        }
        return response;
    }

    @Override
    public BillDTO info(String billId ) {
        Bill data = billRepository.findByBillId(billId);
        BillDTO dto = new BillDTO();
        dto.setBillId(data.getBillId());
        dto.setStudentId(data.getStudentId());
        dto.setPrice(data.getPrice());
        dto.setUserId(dto.getUserId());
        return dto;
    }

    @Override
    public void delete(String billId) {
        Bill data = billRepository.findByBillId(billId);
        billRepository.delete(data);
    }

    @Override
    public void update(String id, BillUpdateDTO dto )  {
        Bill data = billRepository.findByBillId(id);
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bill Invalid!"));
        data.setStudentId(dto.getStudentId());
        data.setPrice(dto.getPrice());
        data.setUpdatedDate(LocalDateTime.now());
        data.setUserId(dto.getUserId());
        billRepository.save(data);
    }
}
