package com.example.rest.controller;

import com.example.rest.dto.CategoryDto;
import com.example.rest.dto.ProductDto;
import com.example.rest.model.Product;
import com.example.rest.service.CategoryService;
import com.example.rest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
    }

}

