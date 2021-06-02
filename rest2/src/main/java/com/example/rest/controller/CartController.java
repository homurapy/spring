package com.example.rest.controller;

import com.example.rest.dto.Cart;
import com.example.rest.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor

public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<Cart> findAll() {
        return cartService.findAll();
    }

    @GetMapping("/{id}")
    public void addProductToCart(@PathVariable Long id){
        cartService.addCart(id);
}
    @DeleteMapping ("/{id}")
        public void subProductToCart(@PathVariable Long id){
        cartService.subCart(id);
        }
    @GetMapping("/fullprice")
    public void fullCartPrice(){
        cartService.fullCartPrice();
    }
}

