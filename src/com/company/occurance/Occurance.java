package com.company.occurance;

import java.util.*;

public class Occurance {
    private String name;
    private Integer occurrence;

    public int countOccurance(List<String> list, String string) {
        return Collections.frequency(list, string);
    }

    public List<Integer> toList(Integer[] array) {
        return Arrays.asList(array);
    }

    public List<Integer> findUnique(List<Integer> arrayList) {
        Set<Integer> set = new LinkedHashSet<>(arrayList);
        return new ArrayList<>(set);
    }

    public void calcOccurance(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(list);
        for (String word : list) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else map.put(word, map.get(word) + 1);
        }
        for (String s : set) {
            System.out.println(s + " = " + map.get(s));
        }
    }

    public List<Occurance> findOccurrence(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(list);
        List<Occurance> occurances = new ArrayList<>();

        for (String word : list) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else map.put(word, map.get(word) + 1);
        }

        for (String s : set) {
            occurances.add(new Occurance(s, map.get(s)));
        }
        return occurances;
    }

    public Occurance(String name, Integer occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    public Occurance() {
    }

    @Override
    public String toString() {
        return "{name: \"" + name +
                "\", occurrence: " + occurrence +
                '}';
    }
}
