package com.example.springdata.repository;

import com.example.springdata.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
List<Product> findProductsByPriceGreaterThan(Integer price);
List<Product> findProductsByPriceLessThan(Integer price);
List<Product> findProductsByPriceBetween(Integer priceMin, Integer priceMax);
List <Product> findByTitle(String name);
}
