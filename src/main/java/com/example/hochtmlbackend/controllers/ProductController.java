package com.example.hochtmlbackend.controllers;

import com.example.hochtmlbackend.DTOs.ProductDTO;
import com.example.hochtmlbackend.DTOs.ProductInfoDTO;
import com.example.hochtmlbackend.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Product API")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Register product guide")
    public void create(@RequestBody ProductDTO dto) {
        productService.create(dto);
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    @Operation(summary = "List product")
    public List<ProductInfoDTO> list() {
        return productService.list();
    }

    @RequestMapping(value = "/product/info", method = RequestMethod.GET)
    @Operation(summary = "Info product")
    public ProductInfoDTO info(@RequestParam(name = "id") String id) {
        return productService.info(id);
    }

    @RequestMapping(value = "/product/delete/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Delete product")
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }

    @RequestMapping(value = "/product/update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update product guide")
    public void update(@PathVariable String id,
                       @RequestBody ProductDTO dto) {
        productService.update(id, dto);
    }
}
