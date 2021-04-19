package com.example.JavaEE;

public class Product {
    private Integer id;
    private String title;
    private Integer cost;

    public Product(Integer id, String title, Integer cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
