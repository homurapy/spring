package com.vasilev.boot.repository;
import com.vasilev.boot.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository

public class ProductRepository {
    private final static List<Product> storage = new CopyOnWriteArrayList<>();
    private final AtomicLong generator = new AtomicLong();

    public Product create(Product product){
        product.setId(generator.incrementAndGet());
        storage.add(product);
        return product;
    }

    public List<Product> findAll() {
     return storage.stream()
                .filter(it -> !it.isDeleted())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Product> findUno(Long id) {
        return storage.stream()
                .filter(it -> id.equals(it.getId()))
                .collect(Collectors.toUnmodifiableList());
    }

    public Product update(Product product) {
        if (product.getId() == null) {
            return null;
        }
        Product existingPerson = storage.stream()
                .filter(it -> it.getId() == product.getId())
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        product.setId(existingPerson.getId());
        product.setVersion(existingPerson.getVersion()+1);
        storage.add(product);
        return product;
    }

    public int deleteById(long id) {
        List<Product> toDelete = storage.stream()
                .filter(it -> it.getId() == id)
                .collect(Collectors.toList());
        toDelete.forEach(it -> it.setDeleted(true));
        return toDelete.size();
    }

}
