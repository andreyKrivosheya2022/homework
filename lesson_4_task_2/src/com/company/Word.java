package com.company;
import java.util.Random;
import java.util.Scanner;

public class Word {
    private final String[] words = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
            "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
            "pineapple", "pumpkin", "potato"};
    private StringBuilder support;

    public void wordGame() {
        String unknownWord = words[new Random().nextInt(words.length - 1)];
        support = new StringBuilder("###############");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your word: ");
            String usersWord = scanner.nextLine();
            if (usersWord.equals(unknownWord)) {
                System.out.println("You are winner");
                break;
            } else {
                showSymbolInTheWord(unknownWord, usersWord);
            }
        }
    }

    private void showSymbolInTheWord(String unknownWord, String userWord) {
        int minNumber = Math.min(unknownWord.length(), userWord.length());
        for (int i = 0; i < minNumber; i++) {
            if (userWord.charAt(i) == unknownWord.charAt(i))
                support.setCharAt(i, unknownWord.charAt(i));

        }
        System.out.println("Your word is wrong \n" + support);
    }
}
