package com.company.phonebook;

public class Main {

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add(new Recording("ANDREY", "+380998617849"));
        phonebook.add(new Recording("ANDREY", "+380993512546"));
        phonebook.add(new Recording("Aleksey", "+380993512546"));

        System.out.println(phonebook.findAll("ANDREY"));
        System.out.println(phonebook.find("Aleksey"));
    }
}
