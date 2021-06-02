package com.vasilev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter

@Entity
@Data
@Table(name = "products")
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

    @ManyToMany
    @JoinTable(
            name = "orders",
            inverseJoinColumns = @JoinColumn (name = "id_buyer"),
             joinColumns = @JoinColumn(name = "id_product")
    )
    private List<Buyer> buyers;

}


