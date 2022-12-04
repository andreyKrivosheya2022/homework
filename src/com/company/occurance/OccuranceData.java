package com.company.occurance;

public class OccuranceData {
    private String name;
    private Integer occurrence;

    public OccuranceData(String name, Integer occurrence){
        this.name = name;
        this.occurrence = occurrence;
    }
    @Override
    public String toString() {
        return "{name: \"" + name +
                "\", occurrence: " + occurrence +
                '}';
    }
}
