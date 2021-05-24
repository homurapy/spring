package com.example.front.controller;

import com.example.front.model.Product;
import com.example.front.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }
    @DeleteMapping
    public  void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }
}

