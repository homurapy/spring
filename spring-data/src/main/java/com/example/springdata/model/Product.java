package com.example.springdata.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    public Product(){}

}


