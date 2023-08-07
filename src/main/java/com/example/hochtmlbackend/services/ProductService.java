package com.example.hochtmlbackend.services;

import com.example.hochtmlbackend.DTOs.ProductDTO;
import com.example.hochtmlbackend.DTOs.ProductInfoDTO;

import java.util.List;

public interface ProductService {
    void create(ProductDTO dto);

    void update(String id, ProductDTO dto);

    List<ProductInfoDTO> list();

    ProductInfoDTO info(String id);

    void delete(String id);
}
