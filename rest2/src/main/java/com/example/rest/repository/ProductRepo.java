package com.example.rest.repository;

import com.example.rest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
