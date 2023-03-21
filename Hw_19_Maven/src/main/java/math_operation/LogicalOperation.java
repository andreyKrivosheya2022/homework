package math_operation;

import java.util.Arrays;

public class LogicalOperation {
    public static boolean isArrayContainsSearchingNumbers(int[] array, int a, int b) {
        return Arrays.stream(array).anyMatch(x -> x == a) && Arrays.stream(array).anyMatch(x -> x == b);
    }

    public static int maxOfArray(int[] array) {
        return Arrays.stream(array).max().getAsInt();
    }
}