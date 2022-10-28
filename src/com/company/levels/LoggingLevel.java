package com.company.levels;

public enum LoggingLevel {
    INFO(0), DEBUG(1);
    private int count;

    LoggingLevel(int level) {
        this.count = level;
    }

    public int getCount() {
        return count;
    }
}
