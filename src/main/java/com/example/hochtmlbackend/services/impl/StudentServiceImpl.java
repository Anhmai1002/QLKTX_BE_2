package com.example.hochtmlbackend.services.impl;

import com.example.hochtmlbackend.DTOs.RoomDTO;
import com.example.hochtmlbackend.DTOs.StudentDTO;
import com.example.hochtmlbackend.DTOs.StudentUpdateDTO;
import com.example.hochtmlbackend.entities.Student;
import com.example.hochtmlbackend.entities.User;
import com.example.hochtmlbackend.repositories.StudentRepository;
import com.example.hochtmlbackend.repositories.UserRepository;
import com.example.hochtmlbackend.services.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;


    @Override
    public void create(StudentDTO dto )  {
        Student student = new Student();
        SecureRandom random = new SecureRandom();
        student.setStudentId(String.format("%04d", random.nextInt(10000)));
        student.setName(dto.getName());
        student.setGender(dto.getGender());
        student.setAddress(dto.getAddress());
        student.setClassName(dto.getClassName());
        student.setFaculty(dto.getFaculty());
        student.setNumberPhone(dto.getNumberPhone());
        student.setCreatedDate(LocalDateTime.now());
        studentRepository.save(student);
    }

    @Override
    public List<StudentDTO> list() {
        List<Student> listData = studentRepository.findAll();
        List<StudentDTO> response = new ArrayList<>();
        for (Student data : listData) {
            StudentDTO dto = new StudentDTO();
            dto.setStudentId(data.getStudentId());
            dto.setName(data.getName());
            dto.setGender(data.getGender());
            dto.setAddress(data.getAddress());
            dto.setClassName(data.getClassName());
            dto.setFaculty(data.getFaculty());
            dto.setNumberPhone(data.getNumberPhone());   
            response.add(dto);
        }
        return response;
    }

    @Override
    public StudentDTO info(String studentId ) {
        Student data = studentRepository.findByStudentId(studentId);
        StudentDTO dto = new StudentDTO();
        dto.setStudentId(data.getStudentId());
        dto.setName(data.getName());
        dto.setGender(data.getGender());
        dto.setAddress(data.getAddress());
        dto.setClassName(data.getClassName());
        dto.setFaculty(data.getFaculty());
        dto.setNumberPhone(data.getNumberPhone());
        return dto;
    }

    @Override
    public void delete(String studentId ) {
        Student data = studentRepository.findByStudentId(studentId);
        studentRepository.delete(data);
    }

    @Override
    public void update(String id, StudentUpdateDTO dto ) {
        Student data = studentRepository.findByStudentId(id);
        data.setName(dto.getName());
        data.setGender(dto.getGender());
        data.setAddress(dto.getAddress());
        data.setClassName(dto.getClassName());
        data.setFaculty(dto.getFaculty());
        data.setNumberPhone(dto.getNumberPhone());
        data.setUpdatedDate(LocalDateTime.now());
        studentRepository.save(data);
    }
}
