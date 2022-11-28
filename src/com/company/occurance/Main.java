package com.company.occurance;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("qwerty","new","banana","new","president","Simba","new","new","orange","Simba",
                "important");
        Integer[] array = {1,2,3,4,5};
        List<Integer> arrayList = Arrays.asList(1,2,3,5,5,5,5,5,5);

        Occurance occurance = new Occurance();
        System.out.println(occurance.countOccurance(list,"new"));
        System.out.println();

        System.out.println(occurance.toList(array));
        System.out.println();

        System.out.println(occurance.findUnique(arrayList));
        System.out.println();

        occurance.calcOccurance(list);
        System.out.println();

        System.out.println(occurance.findOccurrence(list));
    }
}
