package com.example.service;

import com.example.dto.Product;
import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
//@Log4j
public class ProductService {
    private final ProductRepository productRepository;

    public void add(Product product) {
//        log.debug("Adding person");
        if (product.getId() == null) {
            product.setId(UUID.randomUUID());
        }
        productRepository.add(product);
    }

    public List<Product> findAll() {
//        log.debug("findAll");
        return productRepository.findAll();
    }
    public Product findUno(UUID uuid) {
//        log.debug("findUno");
        return productRepository.findUno(uuid);
    }
}
