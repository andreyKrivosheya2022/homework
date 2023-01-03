import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SimpleMathLibraryTest {
    SimpleMathLibrary simpleMathLibrary;

    @BeforeEach
    void object() {
        simpleMathLibrary = new SimpleMathLibrary();
    }

    private static Stream<Arguments> operationsWithNumbers() {
        return Stream.of(
                Arguments.of(-2, 4, 5.0),
                Arguments.of(-0, 2, -2.0),
                Arguments.of(-4, 0, -7.0),
                Arguments.of(-2, -1, 8.0)
        );
    }

    @ParameterizedTest
    @MethodSource("operationsWithNumbers")
    void add(int a, int b, double expectedResult) {
        var actual = simpleMathLibrary.add(a, b);
        System.out.println(actual == expectedResult ? "OK" : "NOK");
    }

    @ParameterizedTest
    @MethodSource("operationsWithNumbers")
    void minus(int a, int b, double expectedResult) {
        var actual = simpleMathLibrary.minus(a, b);
        System.out.println(actual == expectedResult ? "OK" : "NOK");
    }
}
