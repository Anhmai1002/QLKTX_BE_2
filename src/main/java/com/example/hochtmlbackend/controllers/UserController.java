package com.example.hochtmlbackend.controllers;


import com.example.hochtmlbackend.DTOs.UserDTO;
import com.example.hochtmlbackend.DTOs.UserUpdateDTO;
import com.example.hochtmlbackend.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@ControllerAdvice
@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "User API")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Register user guide")
    public void create(@RequestBody UserDTO dto) {
        userService.create(dto);
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    @Operation(summary = "List user")
    public List<UserDTO> list() {
        return userService.list();
    }

    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    @Operation(summary = "Info user")
    public UserDTO info(@RequestParam(name = "id") String id) {
        return userService.info(id);
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Delete room")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }

    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update user")
    public void update(@PathVariable String id,
                       @RequestBody UserUpdateDTO dto) {
        userService.update(id, dto);
    }
}
