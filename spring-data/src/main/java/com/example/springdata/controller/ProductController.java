package com.example.springdata.controller;

import com.example.springdata.model.Product;
import com.example.springdata.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor

public class ProductController {
    private ProductRepo repo;
    @PostMapping
    public Product save(@RequestBody Product product){
        return repo.save(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return (List<Product>) repo.findAll();
    }
    @GetMapping("/search")
    public List <Product> findByName(@RequestParam String name){
        return repo.findByTitle(name);
    }
    @GetMapping("/search")
    public List <Product> findAllGreaterMinPrice(@RequestParam Integer price){
        return repo.findProductsByPriceGreaterThan(price);
    }
    @GetMapping("/search")
    public List <Product> findAllLessMaxPrice(@RequestParam Integer price) {
        return repo.findProductsByPriceLessThan(price);
    }
    @GetMapping("/search")
    public List <Product> findProductsByPriceBetween(@RequestParam Integer min, Integer max) {
        return repo.findProductsByPriceBetween(min, max);
    }
    @DeleteMapping
    public  void deleteById(@PathVariable Long id){
        repo.deleteById(id);
    }
}
