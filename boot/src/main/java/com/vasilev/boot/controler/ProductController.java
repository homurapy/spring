package com.vasilev.boot.controler;


import com.vasilev.boot.dto.ProductDto;
import com.vasilev.boot.model.Product;
import com.vasilev.boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.async.DeferredResult;

import javax.validation.Valid;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    @PostMapping
    public String addPerson(@Valid @ModelAttribute ProductDto productDto, Model model) {
        productService.save(productDto);
        model.addAttribute("message", "Продукт " + productDto.getTitle() + " ,был добавлен");
        return "product";
    }
}
