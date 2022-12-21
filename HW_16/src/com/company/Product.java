package com.company;

import java.time.LocalDate;

public class Product {

    private final int id;
    private final Type type;
    private double cost;
    private boolean discount;
    private final LocalDate now;

    public Product(int id, Type type, double cost, boolean discount, LocalDate now) {
        this.id = id;
        this.type = type;
        this.cost = cost;
        this.discount = discount;
        this.now = now;
    }

    public Type getType() {
        return type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDate getNow() {
        return now;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type=" + type +
                ", cost=" + cost +
                ", discount=" + discount +
                ", now=" + now +
                '}';
    }
}

enum Type {
    BOOK,
    TOY
}