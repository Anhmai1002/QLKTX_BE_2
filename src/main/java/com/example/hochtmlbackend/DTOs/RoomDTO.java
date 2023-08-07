package com.example.hochtmlbackend.DTOs;

import lombok.Data;

@Data
public class RoomDTO {
    String roomId;

    String roomCode;

    String roomType;

    String roomNumberOfBeds;

    String roomPrice;

    String status;

    String userId;
}
