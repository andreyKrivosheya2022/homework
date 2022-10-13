package com.company;

public class Animal {
    private static int animalCount;
    public Animal() {
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
    public void run(int distance){
        System.out.println("Животное пробежало: " + distance + "m");
    }
    public void swim(int distance) {
        System.out.println("Животное проплыло: " + distance + "m");
    }

}
