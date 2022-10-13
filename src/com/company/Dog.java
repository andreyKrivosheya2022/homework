package com.company;

public class Dog extends Animal{
    private static int dogCount;
    public Dog() {
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
    public void run(int distance){
        if ( distance <= 500 && distance >= 0) System.out.println("Бобик пробежал: " + distance + "m");
        else System.out.println("Бобик устал и пробежал всего лишь 500м или вообще не бегал");
    }
    public void swim(int distance){
        if (distance <= 10 && distance >= 0) System.out.println("Бобик проплыл: " + distance + "m");
        else System.out.println("Бобик устал и проплыл всего лишь 10м или вообще не плыл");
    }
}
