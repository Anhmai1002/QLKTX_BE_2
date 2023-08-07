package com.example.hochtmlbackend.controllers;

import com.example.hochtmlbackend.DTOs.ContractDTO;
import com.example.hochtmlbackend.DTOs.ContractUpdateDTO;
import com.example.hochtmlbackend.DTOs.RoomDTO;
import com.example.hochtmlbackend.DTOs.RoomUpdateDTO;
import com.example.hochtmlbackend.services.ContractService;
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
@Tag(name = "Contract API")
@CrossOrigin
public class ContractController {

    @Autowired
    ContractService contractService;

    @RequestMapping(value = "/contract/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Register contract guide")
    
    public void create(@RequestBody ContractDTO dto ) {
        contractService.create(dto );
    }

    @RequestMapping(value = "/contract/list", method = RequestMethod.GET)
    @Operation(summary = "List contract")
    
    public List<ContractDTO> list( ) {
        return contractService.list();
    }

    @RequestMapping(value = "/contract/info", method = RequestMethod.GET)
    @Operation(summary = "Info contract")
    
    public ContractDTO info(@RequestParam(name = "id") String id ) {
        return contractService.info(id );
    }

    @RequestMapping(value = "/contract/delete/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Delete contract")
    
    public void delete(@PathVariable String id ) {
        contractService.delete(id );
    }

    @RequestMapping(value = "/contract/update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update contract")
    
    public void update(@PathVariable String id,
                       @RequestBody ContractUpdateDTO dto
                       ) {
        contractService.update(id, dto );
    }
}
