package com.company;

import java.util.*;

public class Box <T extends Fruit> {
    private final List<T> fruitsBox = new LinkedList<>();

    public void addFruit(T fruit) {
        fruitsBox.add(fruit);
    }

    public void addAllFruits(List<T> list) {
        this.fruitsBox.addAll(list);
    }

    public float getWeight() {
        if (fruitsBox.get(0) != null) {
            return (float) fruitsBox.size() * fruitsBox.get(0).getWeight();
        }
        return -1;
    }

    public boolean compare(Box<? extends Fruit> anotherBox) {
        return this.getWeight() == anotherBox.getWeight();
    }

    public void merge(Box<T> anotherBox) {
        fruitsBox.addAll(anotherBox.fruitsBox);
        anotherBox.fruitsBox.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruitsBox=" + fruitsBox +
                '}';
    }
}
