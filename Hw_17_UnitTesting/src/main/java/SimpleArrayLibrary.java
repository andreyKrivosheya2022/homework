import java.util.Arrays;

public class SimpleArrayLibrary {
    public int[] numbersAfterFour(int[] array) {
        int[] newArray = null;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                newArray = new int[array.length - i - 1];
                System.arraycopy(array, i + 1, newArray, 0, newArray.length);
                break;
            } else if (i == 0) throw new RuntimeException("Array doesn`t contain 4");
        }

        return newArray;
    }

    public boolean isArrayContainsOneAndFour(int[] array) {
        return Arrays.stream(array).anyMatch(element -> element == 1) && Arrays.stream(array).anyMatch(element -> element == 4);
    }
}
