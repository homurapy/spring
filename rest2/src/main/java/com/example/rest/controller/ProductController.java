package com.example.rest.controller;

import com.example.rest.dto.ProductDto;
import com.example.rest.model.Product;
import com.example.rest.service.ProductService;
import com.example.rest.utils.MappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAll(@RequestParam Map<String, String> params) {
        return productService.findAll(params);
    }

    @PostMapping
    public Product save(@RequestBody ProductDto dto) {

        return productService.save(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }
}

