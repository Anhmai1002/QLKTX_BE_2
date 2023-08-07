package com.example.hochtmlbackend.services.impl;

import com.example.hochtmlbackend.DTOs.ProductDTO;
import com.example.hochtmlbackend.DTOs.ProductInfoDTO;
import com.example.hochtmlbackend.entities.Product;
import com.example.hochtmlbackend.repositories.ProductRepository;
import com.example.hochtmlbackend.services.ProductService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DozerBeanMapper mapper;

    @Override
    public void create(ProductDTO dto) {
        SecureRandom random = new SecureRandom();
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setProductId(String.format("%04d", random.nextInt(10000)));
        productRepository.save(product);
    }

    @Override
    public void update(String id, ProductDTO dto) {
        Product data = productRepository.findProductByProductId(id);
        data.setName(dto.getName());
        data.setDescription(dto.getDescription());
        productRepository.save(data);
    }

    @Override
    public List<ProductInfoDTO> list() {
        List<Product> listData = productRepository.findAll();
        List<ProductInfoDTO> listDTO = new ArrayList<>();
        for (Product data : listData) {
            ProductInfoDTO dto = new ProductInfoDTO();
            dto.setName(data.getName());
            dto.setDescription(data.getDescription());
            dto.setId(data.getId().toString());
            dto.setProductId(data.getProductId());
            listDTO.add(dto);
        }
        return listDTO;
    }

    @Override
    public ProductInfoDTO info(String id) {
        Product data = productRepository.findProductByProductId(id);
        ProductInfoDTO dto = new ProductInfoDTO();
        dto.setName(data.getName());
        dto.setDescription(data.getDescription());
        dto.setId(data.getId().toString());
        dto.setProductId(data.getProductId());
        return dto;
    }

    @Override
    public void delete(String id) {
        Product data = productRepository.findProductByProductId(id);
        productRepository.delete(data);
    }

}
