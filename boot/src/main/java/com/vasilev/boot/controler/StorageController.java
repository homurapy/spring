package com.vasilev.boot.controler;

import com.vasilev.boot.dto.ProductDto;
import com.vasilev.boot.model.Product;
import com.vasilev.boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public List<ProductDto> showHtml() {
        return productService.findAll();
    }

    @GetMapping( "/{id}")
    public String deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/storage";
    }
}
