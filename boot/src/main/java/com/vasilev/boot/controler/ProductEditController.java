package com.vasilev.boot.controler;


import com.vasilev.boot.dto.ProductDto;
import com.vasilev.boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productEdit")
public class ProductEditController {

    private final ProductService productService;
    @PostMapping
    public String addPerson(Model model) {
         model.addAttribute("message", "Продукт ,был добавлен");
        return "productEdit";
    }

}
