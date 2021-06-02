package com.example.rest.utils;


import com.example.rest.dto.CategoryDto;
import com.example.rest.dto.ProductDto;
import com.example.rest.model.Category;
import com.example.rest.model.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MappingUtil {
    public static ProductDto productDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice(), product.getCategory().getName());
    }
    public static CategoryDto categoryDto(Category category) {
        return new CategoryDto(category.getName());
    }

    public static Product dtoToProduct(ProductDto dto, Category category) {
        return new Product(dto.getId(), dto.getTitle(), dto.getPrice(), 1, category);
    }
    public static Category dtoToCategory(CategoryDto categoryDto, Long id) {
        return new Category(id, categoryDto.getName(), null);
    }

}
