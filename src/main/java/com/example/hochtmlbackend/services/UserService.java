package com.example.hochtmlbackend.services;

import com.example.hochtmlbackend.DTOs.UserDTO;
import com.example.hochtmlbackend.DTOs.UserUpdateDTO;

import java.io.IOException;
import java.util.List;

public interface UserService {

    void create(UserDTO dto );

    List<UserDTO> list();

    UserDTO info(String userId);

    void delete(String userId);

    void update(String id, UserUpdateDTO dto);
}
