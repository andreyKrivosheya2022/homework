package com.example.spring_web_servlet.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private Long id;
    private LocalDateTime date;
    private BigDecimal cost;
    private List<Product> products;

    public Order(Long id, LocalDateTime date, BigDecimal cost, List<Product> products) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.products = products;
    }
}
