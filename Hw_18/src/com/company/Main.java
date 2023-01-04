package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3};
        System.out.println(toList(array));

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.addFruit(new Orange());
        orangeBox2.addFruit(new Orange());

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());

        Box<Apple> appleBox = new Box<>();
        appleBox.addAllFruits(apples);

        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox.compare(appleBox));
        orangeBox.merge(orangeBox2);
        System.out.println(orangeBox.getWeight());
    }

    public static List<Object> toList(Object[] array){
        return  Arrays.stream(array).toList();
    }
}
