package $10_unit_test.$03_exception_test.demo01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    @Test
    void testNegative() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Factorial.fact(-1);
            }
        });
    }

    @Test
    void testNegative2() {
        assertEquals(2432902008176640000L, Factorial.fact(20));
        assertThrows(ArithmeticException.class, () -> Factorial.fact(21));
    }
}
