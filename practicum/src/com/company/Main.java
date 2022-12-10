package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("123");
        arrayList.add("123");
        arrayList.add("1");
        arrayList.add("23");

        System.out.println(arrayList.remove("1"));

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));

        System.out.println(Arrays.toString(arrayList.toArray()));

        System.out.println(arrayList.isEmpty());

        System.out.println(arrayList.size());

        arrayList.clear();

        System.out.println(arrayList.size());

        arrayList.add("123");
        arrayList.add("123");
        arrayList.add("1");
        arrayList.add("23");
        System.out.println(arrayList.size());
    }
}
