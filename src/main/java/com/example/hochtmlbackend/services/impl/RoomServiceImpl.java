package com.example.hochtmlbackend.services.impl;

import com.example.hochtmlbackend.DTOs.RoomDTO;
import com.example.hochtmlbackend.DTOs.RoomUpdateDTO;
import com.example.hochtmlbackend.entities.Room;
import com.example.hochtmlbackend.entities.User;
import com.example.hochtmlbackend.repositories.RoomRepository;
import com.example.hochtmlbackend.repositories.UserRepository;
import com.example.hochtmlbackend.services.RoomService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;

    @Override
    public void create(RoomDTO dto)  {
        Room room = new Room();
        SecureRandom random = new SecureRandom();
        room.setRoomId(String.format("%04d", random.nextInt(10000)));
        room.setRoomCode(dto.getRoomCode());
        room.setRoomType(dto.getRoomType());
        room.setRoomNumberOfBeds(dto.getRoomNumberOfBeds());
        room.setRoomPrice(dto.getRoomPrice());
        room.setUserId(dto.getUserId());
        roomRepository.save(room);
    }

    @Override
    public List<RoomDTO> list() {
        List<Room> listData = roomRepository.findAll();
        List<RoomDTO> response = new ArrayList<>();
        for (Room data : listData) {
            RoomDTO dto = new RoomDTO();
            dto.setRoomId(data.getRoomId());
            dto.setRoomCode(data.getRoomCode());
            dto.setRoomType(data.getRoomType());
            dto.setRoomNumberOfBeds(data.getRoomNumberOfBeds());
            dto.setRoomPrice(data.getRoomPrice());
            dto.setUserId(dto.getUserId());
            response.add(dto);
        }
        return response;
    }

    @Override
    public RoomDTO info(String roomId) {
        Room data = roomRepository.findByRoomId(roomId);
        RoomDTO dto = new RoomDTO();
        dto.setRoomId(data.getRoomId());
        dto.setRoomCode(data.getRoomCode());
        dto.setRoomType(data.getRoomType());
        dto.setRoomNumberOfBeds(data.getRoomNumberOfBeds());
        dto.setRoomPrice(data.getRoomPrice());
//        dto.setUserId(dto.getUserId());
        return dto;
    }

    @Override
    public void delete(String roomId) {
        Room data = roomRepository.findByRoomId(roomId);
        roomRepository.delete(data);
    }

    @Override
    public void update(String id, RoomUpdateDTO dto)  {
        Room data = roomRepository.findByRoomId(id);
        data.setRoomCode(dto.getRoomCode());
        data.setRoomType(dto.getRoomType());
        data.setRoomNumberOfBeds(dto.getRoomNumberOfBeds());
        data.setRoomPrice(dto.getRoomPrice());
        data.setUserId(dto.getUserId());
        roomRepository.save(data);
    }
}
