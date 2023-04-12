package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
public class Product {
    private long id;
    private String name;
    private BigDecimal price;
}
