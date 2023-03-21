
import math_operation.ArithmeticOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArithmeticOperationTest {
    int x,y;

    @BeforeEach
    void setUp() {
        x = 5;
        y = 10;
    }

    @Test
    public void testAdd() {
        int result = 15;
        assertThat(result).isEqualTo(ArithmeticOperation.add(x,y));
    }

    @Test
    public void testMinus() {
        int result = 5;
        assertThat(result).isEqualTo(ArithmeticOperation.abs(ArithmeticOperation.minus(x,y)));
    }

}
