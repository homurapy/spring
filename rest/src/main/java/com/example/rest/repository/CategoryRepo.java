package com.example.rest.repository;

import com.example.rest.model.Category;
import com.example.rest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Product> {
Category getByName(String name);
}
