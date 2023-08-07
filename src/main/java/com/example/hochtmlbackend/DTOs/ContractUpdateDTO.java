package com.example.hochtmlbackend.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ContractUpdateDTO {

    String startDay;

    String endDay;

    String studentId;

    String roomId;

    String userId;
}
