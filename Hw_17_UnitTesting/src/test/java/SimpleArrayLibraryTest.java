import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SimpleArrayLibraryTest {
    SimpleArrayLibrary simpleArrayLibrary;

    @BeforeEach
    void init() {
        simpleArrayLibrary = new SimpleArrayLibrary();
    }

    @Before
    private static Stream<Arguments> arraysWithNumbersAfterFour() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{5, 6}),
                Arguments.of(new int[]{4}, new int[]{}),
                Arguments.of(new int[]{6, 5, 4, 3, 2, 1}, new int[]{3, 2, 1})
        );
    }

    @Before
    private static Stream<Arguments> randomArraysToCheckIsArrayContainsOneAndFour() {
        return Stream.of(
                Arguments.of(new int[]{0, 2, 3, 6, 6, 0, 4, 2, 3}, false),
                Arguments.of(new int[]{4, 5, 6, 7, 8, 9}, false),
                Arguments.of(new int[]{1, 1, 1, 1}, false),
                Arguments.of(new int[]{1, 4}, true)
        );
    }

    @Test
    public void numberDoesNotContainsInArray() {
        assertThrows(RuntimeException.class, () -> simpleArrayLibrary.numbersAfterFour(new int[]{1, 2, 3}));
    }


    @ParameterizedTest
    @MethodSource("arraysWithNumbersAfterFour")
    void isNumbersAfterFourTrue(int[] inputArray, int[] expectedArray) {
        int[] input = simpleArrayLibrary.numbersAfterFour(inputArray);
        Assertions.assertArrayEquals(expectedArray, input);
    }

    @ParameterizedTest
    @MethodSource("randomArraysToCheckIsArrayContainsOneAndFour")
    void IsArrayContainsOneAndFour(int[] array, boolean isContain) {
        boolean actual = simpleArrayLibrary.isArrayContainsOneAndFour(array);
        assertEquals(isContain, actual);
    }
}