package com.example.hochtmlbackend.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {

    String userId;

    String Name;

    String birthday;

    String gender;

    String role;

    String address;

    String email;

    String password;

}
