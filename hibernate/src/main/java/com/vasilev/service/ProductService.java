package com.vasilev.service;

import com.vasilev.dao.ProductDao;
import com.vasilev.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;


@RequiredArgsConstructor
public class ProductService {

    private  ProductDao productDao = new ProductDao();

    public void save(Product product) {
     productDao.save(product);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void deleteById(Long id) {
        productDao.delete(productDao.findById(id));
    }
}
