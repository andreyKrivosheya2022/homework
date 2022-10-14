package com.company;

public class Circle implements Figure {
    private final double r;

    public Circle (double r){
        this.r = r;
    }
    public double area(){
        return Math.PI * r * r;
    }
}
