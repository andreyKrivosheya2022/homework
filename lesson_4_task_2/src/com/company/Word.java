package com.company;
import java.util.Random;
import java.util.Scanner;

public class Word {
    private final String[] words = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
            "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
            "pineapple", "pumpkin", "potato"};
    private final String unknownWord = words[new Random().nextInt(words.length - 1)];
    private final StringBuilder support = new StringBuilder("###############");

    public void wordGame() {
        while (true) {
            System.out.println("Введите ваше слово: ");
            String scanner = new Scanner(System.in).nextLine();
            if (scanner.equals(unknownWord)) {
                System.out.println("You are winner");
                break;
            } else {
                printHiddenWord(unknownWord,scanner);
                System.out.println("Ваше слово неверное \n" + support);
                System.out.println();
            }
        }
    }

    private void printHiddenWord(String unknownWord, String scanner) {
        int minNumber = Math.min(unknownWord.length(),scanner.length());
        for (int i = 0; i < minNumber; i++) {
            if (scanner.charAt(i) == unknownWord.charAt(i)) {
                support.setCharAt(i, unknownWord.charAt(i));
            }
        }
    }
}
