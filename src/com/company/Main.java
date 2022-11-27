package com.company;

public class Main {

    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add("/folder/", new FileData("Text.txt", "/folder/", 32));
        fileNavigator.add("/folder/", new FileData("Text1.txt", "/folder/", 42));
        fileNavigator.add("/folder/", new FileData("Tex.txt", "/folder/", 52));
        fileNavigator.add("/folder/", new FileData("Text2.txt", "/folder/", 82));
        fileNavigator.add("/folder/", new FileData("Tex1.txt", "/folder/", 12));
        fileNavigator.add("/folder/", new FileData("Text4.txt", "/folder/", 2));

        System.out.println(fileNavigator.find("/folder/"));
        System.out.println(fileNavigator.filterBySize(33));
        System.out.println(fileNavigator.sortBySize());

        fileNavigator.remove("/folder/");
    }
}
