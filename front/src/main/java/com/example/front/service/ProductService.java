package com.example.front.service;

import com.example.front.model.Product;
import com.example.front.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {
    private final ProductRepo repo;

    public Product save(Product product){
        return repo.save(product);
    }
   public List<Product> findAll(){
        return repo.findAll();
    }
    public List <Product> findAllGreaterPrice(Integer price){
        return repo.findProductsByPriceGreaterThan(price);
    }
    public  void deleteById(Long id){
        repo.deleteById(id);
    }
}
