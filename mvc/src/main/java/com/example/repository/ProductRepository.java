package com.example.repository;

import com.example.dto.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository

public class ProductRepository {
    private final static List<Product> storage = new CopyOnWriteArrayList<>();

    public void add(Product product) {
        storage.add(product);
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(storage);
    }
    public Product findUno(UUID uuid) {
        for (Product p: storage) {
            if (uuid.equals(p.getId())){
                return p;
            }
        }
        return null;
    }
}
