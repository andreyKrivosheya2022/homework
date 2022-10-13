package com.company;

public class Main {

    public static void main(String[] args) {
   /*Cat catBarsik = new Cat();
    catBarsik.run(34);
    catBarsik.swim(10);
    Dog dogBobik = new Dog();
    dogBobik.run(150);
    dogBobik.swim(20);
    Animal animal = new Animal(); */

    System.out.println("Общее количество котов: " + Cat.getCatCount() + "\nОбщее количество собак: " + Dog.getDogCount() + "\nОбщее количество остальных животных:  " + (Animal.getAnimalCount()-Dog.getDogCount()-Cat.getCatCount()) );
    }
}
