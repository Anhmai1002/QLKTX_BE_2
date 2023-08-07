package com.example.hochtmlbackend.services.impl;

import com.example.hochtmlbackend.DTOs.UserDTO;
import com.example.hochtmlbackend.DTOs.UserUpdateDTO;
import com.example.hochtmlbackend.entities.User;
import com.example.hochtmlbackend.repositories.UserRepository;
import com.example.hochtmlbackend.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;



    @Override
    public void create(UserDTO dto ) {
        User user = new User();
        SecureRandom random = new SecureRandom();
        user.setUserId(String.format("%04d", random.nextInt(10000)));
        user.setName(dto.getName());
        user.setBirthday(dto.getBirthday());
        user.setGender(dto.getGender());
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setCreatedDate(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> list() {
        List<User> listData = userRepository.findAll();
        List<UserDTO> response = new ArrayList<>();
        for (User data : listData) {
            UserDTO dto = new UserDTO();
            dto.setUserId(data.getUserId());
            dto.setName(data.getName());
            dto.setBirthday(data.getBirthday());
            dto.setGender(data.getGender());
            dto.setAddress(data.getAddress());
            dto.setEmail(data.getEmail());
            dto.setPassword(data.getPassword());
            response.add(dto);
        }
        return response;
    }

    @Override
    public UserDTO info(String userId) {
        User dto = userRepository.findByUserId(userId);
        UserDTO admin = new UserDTO();
        admin.setUserId(dto.getUserId());
        admin.setName(dto.getName());
        admin.setBirthday(dto.getBirthday());
        admin.setGender(dto.getGender());
        admin.setAddress(dto.getAddress());
        admin.setEmail(dto.getEmail());
        admin.setPassword(dto.getPassword());
        return admin;
    }

    @Override
    public void delete(String userId ) {
        User user = userRepository.findByUserId(userId);
        userRepository.delete(user);
    }

    @Override
    public void update(String id, UserUpdateDTO dto ) {
        User user = userRepository.findByUserId(id);
        user.setName(dto.getName());
        user.setBirthday(dto.getBirthday());
        user.setGender(dto.getGender());
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setUpdatedDate(LocalDateTime.now());
        userRepository.save(user);
    }
}
