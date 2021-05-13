package com.example.controller;

import com.example.dto.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author antonkuznetsov
 */
@Controller
@RequestMapping("/storage")
@RequiredArgsConstructor

public class StorageController {

    private final ProductService productService;

    @GetMapping
    @ModelAttribute("products")
    public List<Product> showHtml() {
        return productService.findAll();
    }

}
