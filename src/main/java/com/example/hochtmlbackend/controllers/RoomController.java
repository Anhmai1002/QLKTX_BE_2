package com.example.hochtmlbackend.controllers;

import com.example.hochtmlbackend.DTOs.RoomDTO;
import com.example.hochtmlbackend.DTOs.RoomUpdateDTO;
import com.example.hochtmlbackend.services.RoomService;
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
@Tag(name = "Room API")
@CrossOrigin
public class RoomController {
    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/room/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Register room guide")
    public void create(@RequestBody RoomDTO dto ) {
        roomService.create(dto);
    }

    @RequestMapping(value = "/room/list", method = RequestMethod.GET)
    @Operation(summary = "List room")
    public List<RoomDTO> list() {
        return roomService.list();
    }

    @RequestMapping(value = "/room/info", method = RequestMethod.GET)
    @Operation(summary = "Info room")
    public RoomDTO info(@RequestParam(name = "id") String id ) {
        return roomService.info(id);
    }

    @RequestMapping(value = "/room/delete/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Delete room")
    public void delete(@PathVariable String id ) {
        roomService.delete(id);
    }

    @RequestMapping(value = "/room/update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update room")
    public void update(@PathVariable String id,
                       @RequestBody RoomUpdateDTO dto ) {
        roomService.update(id, dto);
    }
}
