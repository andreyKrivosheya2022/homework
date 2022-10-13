package com.company;

public class Cat extends Animal{
    private static int catCount;
    public Cat() {
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public void run(int distance){
        if (distance <=200) System.out.println("Барсик пробежал: " + distance + "m");
        else System.out.println("Барсик устал и пробежал всего лишь 200м или вообще не бегал");
    }
    public void swim(int distance){
        System.out.println("Барсик не умеет плавать ");
    }
}
