package com.company;

public class HomeWorkApp {

    public static void main(String[] args) {
        printThreeWords();
        System.out.println();

        checkSumSign(4, -6);
        System.out.println();

        printColor(654);
        System.out.println();

        compareNumbers(3,6);
        System.out.println();

        System.out.println(isSumWhichIn(3,8));
        System.out.println();

        isPositive(0);
        System.out.println();

        System.out.println(isNegative(-3));
        System.out.println();

        printSting("Andrey ",3);
        System.out.println();

        System.out.println(isLeapYear(2008));

    }

    public static void printThreeWords() {
        System.out.println("Orange \nBanana \nApple");
    }

    public static void checkSumSign(int a, int b) {
        System.out.println(a + b >= 0 ? "Сумма положительная" : "Сумма отрицательная");
    }

    public static void printColor(int value) {
        if (value > 100) {
            System.out.println("Зеленый");
        } else if (value > 0) {
            System.out.println("Желтый");
        } else {
            System.out.println("Красный");
        }
    }

    public static void compareNumbers(int a, int b) {
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    public static boolean isSumWhichIn(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void isPositive(int a) {
        System.out.println( a >= 0 ? "Положительное" : "Oтрицательное");
    }

    public static boolean isNegative(int value) {
        return value < 0;
    }

    public static void printSting(String str, int n) {
        System.out.println(str.repeat(n));
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
