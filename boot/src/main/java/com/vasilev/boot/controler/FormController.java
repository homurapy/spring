package com.vasilev.boot.controler;

import com.vasilev.boot.dto.ProductDto;
import com.vasilev.boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class FormController {
    private ProductService productService;

    @GetMapping("/")
    public String index() {
        return "form";
    }
}

