package com.company;

public class Main {

    public static void main(String[] args) {

        Stack stack = new Stack(5);

        System.out.println(stack.isEmpty());

        stack.push(4);
        stack.push(3);

        System.out.println(stack.pop());
        stack.pop();

        System.out.println(stack.pick());
    }
}
