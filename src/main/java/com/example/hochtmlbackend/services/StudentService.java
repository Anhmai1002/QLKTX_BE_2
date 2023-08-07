package com.example.hochtmlbackend.services;

import com.example.hochtmlbackend.DTOs.StudentDTO;
import com.example.hochtmlbackend.DTOs.StudentUpdateDTO;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    void create(StudentDTO dto ) ;

    List<StudentDTO> list();

    StudentDTO info(String studentId);

    void delete(String studentId);

    void update(String id, StudentUpdateDTO dto );
}
