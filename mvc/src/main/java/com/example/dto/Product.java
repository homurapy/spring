package com.example.dto;

import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Product {
    private UUID id;
    private String title;
    private Integer cost;
    }

