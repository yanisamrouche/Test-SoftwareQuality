import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculTest {

    @Test
    @DisplayName("factorielle de 2")
    void factorielle() {
        Calcul c = new Calcul();
        int res = c.factorielle(2);
        assertEquals(2 , res, "fact");
    }

    @Test
    @DisplayName("division de deux nombres")
    void division() {
        Calcul c = new Calcul();
        double result = c.division(1, 2);
        assertEquals(0.5, result);
    }

    @Test
    @DisplayName("division par 0")
    public void divisionByZero() {
        Calcul c = new Calcul();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            c.division(5,0);
        });

        String expectedMessage = "hahouwa";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}