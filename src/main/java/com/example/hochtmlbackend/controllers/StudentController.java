package com.example.hochtmlbackend.controllers;

import com.example.hochtmlbackend.DTOs.StudentDTO;
import com.example.hochtmlbackend.DTOs.StudentUpdateDTO;

import com.example.hochtmlbackend.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@ControllerAdvice
@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Student API")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/student/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Register student guide")
    public void create(@RequestBody StudentDTO dto) {
        studentService.create(dto);
    }

    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
    @Operation(summary = "List student")
    public List<StudentDTO> list( ) {
        return studentService.list();
    }

    @RequestMapping(value = "/student/info", method = RequestMethod.GET)
    @Operation(summary = "Info student")
    public StudentDTO info(@RequestParam(name = "id") String id) {
        return studentService.info(id);
    }

    @RequestMapping(value = "/student/delete/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Delete student")
    public void delete(@PathVariable String id) {
        studentService.delete(id);
    }

    @RequestMapping(value = "/student/update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update student")
    public void update(@PathVariable String id,
                       @RequestBody StudentUpdateDTO dto)  {
        studentService.update(id, dto);
    }
}
