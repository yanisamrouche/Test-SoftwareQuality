import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculParametrizedTest {

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "2, 2", "3, 6", "4, 24"})
    void testFactorielle(int n, int res_attendu) {
        Calcul c = new Calcul();
        int res = c.factorielle(n);
        System.out.println("fact(" + n + ") = " + res + " attendu : "
                + res_attendu);
        assertEquals(res_attendu, res);
    }
    @ParameterizedTest
    @CsvSource({"5, 1, 5", "1, 2, 0.5", "3, 2, 1.5", "5, 2, 2.5"})
    void testDivision(int x, int y, float res_attendu) {
        Calcul c = new Calcul();
        float res = c.division(x,y);
        System.out.println("div "+" : "+" resultat : "
                + res_attendu);
        assertEquals(res_attendu, res);
    }
}

