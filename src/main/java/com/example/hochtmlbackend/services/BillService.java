package com.example.hochtmlbackend.services;



import com.example.hochtmlbackend.DTOs.BillDTO;
import com.example.hochtmlbackend.DTOs.BillUpdateDTO;

import java.io.IOException;
import java.util.List;

public interface BillService {
    void create(BillDTO dto);

    List<BillDTO> list();

    BillDTO info(String billId );

    void delete(String billId );

    void update(String id, BillUpdateDTO dto );
}
