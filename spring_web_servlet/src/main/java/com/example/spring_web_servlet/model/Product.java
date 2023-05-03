package com.example.spring_web_servlet.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Long id;
    private String name;
    private BigDecimal cost;

    public Product(long id, String name, BigDecimal cost) {
     this.id = id;
     this.name = name;
     this.cost = cost;
    }
}
