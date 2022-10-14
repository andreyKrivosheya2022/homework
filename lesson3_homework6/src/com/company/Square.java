package com.company;

public class Square implements Figure {
    private final double a;

    public Square (double a){
        this.a = a;
    }
    public double area(){
        return a * a;
    }


}
