import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    void addition() {
        Operation op = new Operation(1,2);
        assertEquals(3,op.addition());
    }

    @Test
    void substraction() {
        Operation op = new Operation(1,2);
        assertEquals(-1,op.substraction());
    }

    @Test
    void multiplication() {
        Operation op = new Operation(1,2);
        assertEquals(2,op.multiplication());
    }

    @Test
    void division() {
        Operation op = new Operation(1,2);
        assertEquals(0.5,op.division());
    }

    @Test
    void divisionByZero() {
        Operation op = new Operation(1,0);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            op.division();
        });
        String expectedMessage = "IllegalArgumentException";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}