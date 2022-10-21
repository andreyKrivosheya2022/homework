package com.company;

import com.company.exception.ArrayDataException;
import com.company.exception.ArraySizeException;

public class Main {

    public static void main(String[] args) {

        String[][] array = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        try {
            System.out.println(new ArrayValueCalculator().doCalc(array));
        } catch (ArraySizeException e) {
            System.out.println(e.getMessage() + ": Array must be 4 x 4");
        } catch (ArrayDataException e) {
            System.out.println(e.getMessage() + " in " + e.getIndex());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

