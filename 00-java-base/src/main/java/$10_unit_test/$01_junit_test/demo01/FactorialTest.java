package $10_unit_test.$01_junit_test.demo01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    @Test
    void testFact() {
        assertEquals(1, Factorial.fact(1));
        assertEquals(2, Factorial.fact(2));
        assertEquals(6, Factorial.fact(3));
        assertEquals(3628800, Factorial.fact(10));
        assertEquals(2432902008176640000L, Factorial.fact(20));
    }

    @Test
    void testEquals() {
        assertEquals(0.1, Math.abs(1 - 9 / 10.0), 0.0000001);
    }
}