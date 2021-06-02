package com.example.rest.dto;

import com.example.rest.model.Category;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {
    private Long id;
    private String title;
    private Integer price;
    private String category;
}



