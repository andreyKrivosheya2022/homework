package com.company.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private final Map<String, List<String>> map = new HashMap<>();

    public void add(Recording recording) {
        if (map.containsKey(recording.getName())) {
            map.get(recording.getName()).add(recording.getPhoneNumber());
        } else {
            List<String> list = new ArrayList<>();
            list.add(recording.getPhoneNumber());
            map.put(recording.getName(), list);
        }
    }

    public String find(String name) {
        return map.get(name).get(0);
    }

    public List<String> findAll(String name) {
        return map.get(name);
    }
}
