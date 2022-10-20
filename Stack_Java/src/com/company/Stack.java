package com.company;

public class Stack {
    private final int[] array;
    private int index = -1;

    public Stack(int size) {
        array = new int[size];
    }

    public boolean isEmpty() {
        return index == -1;
    }

    public void push (int a) {
        index++;
        array[index] = a;
        System.out.println("Top is " + index);
    }

    public int pop() {
        if(isEmpty()){
            System.out.println("Stack is empty");
            return 0;
        } else {
            return array[index--];
        }
    }

    public int pick() {
        if(isEmpty()){
            System.out.println("Stack is empty");
            return 0;
        } else return array[index];
    }
}
