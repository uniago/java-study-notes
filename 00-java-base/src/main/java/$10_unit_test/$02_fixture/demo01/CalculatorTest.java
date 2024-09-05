package $10_unit_test.$02_fixture.demo01;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    public static void initDatabase() {
        // db = createDb(...);
        System.out.println("test init...");
    }

    @AfterAll
    public static void dropDatabase() {
        // ...
        System.out.println("test destroy...");
    }

    @BeforeEach
    public void setUp() {
        this.calculator = new Calculator();
        System.out.println("---test start---");
    }

    @AfterEach
    public void tearDown() {
        this.calculator = null;
        System.out.println("---test end---");
    }

    @Test
    void testAdd() {
        assertEquals(100, this.calculator.add(100));
        assertEquals(150, this.calculator.add(50));
        assertEquals(130, this.calculator.add(-20));
        System.out.println("test add");
    }

    @Test
    void testSub() {
        assertEquals(-100, this.calculator.sub(100));
        assertEquals(-150, this.calculator.sub(50));
        assertEquals(-130, this.calculator.sub(-20));
        System.out.println("test sub");
    }
}