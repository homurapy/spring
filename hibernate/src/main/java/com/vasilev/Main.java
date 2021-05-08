package com.vasilev;

import com.vasilev.service.ProductService;
import com.vasilev.model.Product;
import java.util.List;
public class Main {

    public static void main(String[] args) {

        ProductService productService = new ProductService();
        Product product = new Product(1L,"мясо", 500);
        productService.save(product);

    }

}
