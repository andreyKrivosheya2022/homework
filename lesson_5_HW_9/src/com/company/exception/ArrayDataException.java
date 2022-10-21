package com.company.exception;

public class ArrayDataException extends Exception {
    private final int x,y;

    public ArrayDataException(String message, int x, int y) {
        super(message);
        this.x = x;
        this.y = y;
    }

    public String getIndex() {
        return String.format("[%d][%d]",x,y);
    }
}
