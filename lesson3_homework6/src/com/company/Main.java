package com.company;

public class Main {

    public static void main(String[] args){

        Figure[] figures = {new Circle(4), new Square(2), new Triangle(3,4,5)};
        totalArea(figures);

        //Circle: 3.14 * 4 * 4 = 50.24
        //Square: 2 * 2 = 4
        //Triangle: 6
        //total : 60.24
    }
    public static double totalArea(Figure[] figures){
        double totalArea = 0;
        for (int i = 0; i < figures.length; i++) {
            totalArea += figures[i].area();
        }
        System.out.println("Общая площадь фигур: " + totalArea);
        return totalArea;
    }
}
