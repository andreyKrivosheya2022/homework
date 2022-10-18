package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(findSymbolOccurance("Hello world", 'l'));
        System.out.println();

        System.out.println(findWordPosition("Apollo", "pollo"));
        System.out.println();

        System.out.println(stringReverse("Hello"));
        System.out.println();

        System.out.println(isPalindrome("Allo"));

        Word word = new Word();
        word.wordGame();
    }

    public static int findSymbolOccurance(String line, char symbol) {
        int num = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == symbol) num++;
        }
        return num;
    }

    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    public static String stringReverse(String source) {
        return new StringBuilder(source).reverse().toString();
    }

    public static boolean isPalindrome(String source) {
        return source.equals(new StringBuilder(source).reverse().toString());
    }
}
