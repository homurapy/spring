package com.vasilev;

import com.vasilev.model.Buyer;
import com.vasilev.service.BuyerService;
import com.vasilev.service.ProductService;
import com.vasilev.model.Product;
import java.util.List;
public class Main {

    public static void main(String[] args) {

        ProductService productService = new ProductService();
        BuyerService buyerService= new BuyerService();
        productService.findAll().forEach(product -> System.out.println(product.getTitle()));
        buyerService.getProductBuyer(1L).forEach(buyer -> System.out.println(buyer.getTitle()));


    }

}
