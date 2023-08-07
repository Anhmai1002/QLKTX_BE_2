package com.example.hochtmlbackend.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserUpdateDTO {

    String name;

    String birthday;

    String gender;

    String role;

    String address;

    String email;

    String password;


}
