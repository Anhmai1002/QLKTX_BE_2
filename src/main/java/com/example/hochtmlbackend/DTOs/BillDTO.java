package com.example.hochtmlbackend.DTOs;

import lombok.Data;

@Data
public class BillDTO {

    String billId;

    String studentId;

    int price;

    String userId;
}
