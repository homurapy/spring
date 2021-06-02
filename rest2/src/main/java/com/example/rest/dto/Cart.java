package com.example.rest.dto;

import com.example.rest.model.Product;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart{
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;
}
