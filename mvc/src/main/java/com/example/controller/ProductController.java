package com.example.controller;


import com.example.dto.Product;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author antonkuznetsov
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public String addPerson(@ModelAttribute Product product, Model model) {
        productService.add(product);
        model.addAttribute("message", "Продукт " + product.getTitle() + " ,был добавлен");
        return "product";
    }

    @PostMapping("async")
    public DeferredResult<Product> getProduct() {
        DeferredResult<Product> result = new DeferredResult<>();
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                Thread.sleep(10000);
                result.setResult(new Product());
            } catch (InterruptedException e) {
                e.printStackTrace();
                result.setErrorResult("");
            }
        });
        return result;
    }
}
