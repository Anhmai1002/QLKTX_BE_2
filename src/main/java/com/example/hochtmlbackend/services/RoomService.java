package com.example.hochtmlbackend.services;

import com.example.hochtmlbackend.DTOs.RoomDTO;
import com.example.hochtmlbackend.DTOs.RoomUpdateDTO;

import java.io.IOException;
import java.util.List;

public interface RoomService {
    void create(RoomDTO dto ) ;

    List<RoomDTO> list();

    RoomDTO info(String roomId);

    void delete(String roomId);

    void update(String id, RoomUpdateDTO dto ) ;
}
