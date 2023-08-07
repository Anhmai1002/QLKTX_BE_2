package com.example.hochtmlbackend.controllers;

import com.example.hochtmlbackend.DTOs.BillDTO;
import com.example.hochtmlbackend.DTOs.BillUpdateDTO;

import com.example.hochtmlbackend.services.BillService;
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
@Tag(name = "Bill API")
@CrossOrigin
public class BillController {

    @Autowired
    BillService billService;

    @RequestMapping(value = "/bill/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Register bill guide")
    public void create(@RequestBody BillDTO dto)  {
        billService.create(dto);
    }

    @RequestMapping(value = "/bill/list", method = RequestMethod.GET)
    @Operation(summary = "List bill")
    public List<BillDTO> list() {
        return billService.list();
    }

    @RequestMapping(value = "/bill/info", method = RequestMethod.GET)
    @Operation(summary = "Info bill")
    public BillDTO info(@RequestParam(name = "id") String id) {
        return billService.info(id);
    }

    @RequestMapping(value = "/bill/delete/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Delete bill")
    public void delete(@PathVariable String id) {
        billService.delete(id);
    }

    @RequestMapping(value = "/bill/update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update bill")
    public void update(@PathVariable String id,
                       @RequestBody BillUpdateDTO dto)  {
        billService.update(id, dto);
    }
}
