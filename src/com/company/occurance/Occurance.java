package com.company.occurance;

import java.util.*;

public class Occurance {
    public int countOccurance(List<String> list, String string) {
        return Collections.frequency(list, string);
    }

    public List<Integer> toList(Integer[] array) {
        return Arrays.asList(array);
    }

    public Set<Integer> findUnique(List<Integer> arrayList) {
        return new HashSet<>(arrayList);
    }

    public Map<String, Integer> calcOccurance(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : list) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else map.put(word, map.get(word) + 1);
        }
        return map;
    }

    public void findOccurrence(List<String> list) {
        calcOccurance(list);
        Set<String> mySet = new HashSet<>(list);
        for (String word : mySet) {
            System.out.println("{name: " + word + ", " + "occurrence: " + calcOccurance(list).get(word) + "},");
        }

    }
}
