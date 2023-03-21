import math_operation.LogicalOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicalOperationTest {
    int[] array;
    int x,y;

    @BeforeEach
    void setUp() {
        array = new int[]{1, 2, 3, 4, 5, 6, 222, 5, 24, 4};
        x = 1;
        y = 24;
    }

    @Test
    public void testMaxOfArray() {
        int result = 222;
        assertThat(result).isEqualTo(LogicalOperation.maxOfArray(array));
    }

    @Test
    public void testIsArrayContainsSearchingNumbers() {
        assertTrue(LogicalOperation.isArrayContainsSearchingNumbers(array, x, y));
    }

}
