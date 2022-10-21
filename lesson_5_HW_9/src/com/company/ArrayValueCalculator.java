package com.company;

import com.company.exception.ArrayDataException;
import com.company.exception.ArraySizeException;

public class ArrayValueCalculator {

    public int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        int result = 0;
        if(array.length != 4) throw new ArraySizeException("Wrong index");
        for(int i = 0; i < 4; i++) {
            if(array[i].length != 4) throw new ArraySizeException("Wrong index");
            for (int j = 0; j < 4; j++){
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException(e.getMessage() + String.format(" in [%d][%d]",i,j));
                }
            }
        }
        return result;
    }
}
