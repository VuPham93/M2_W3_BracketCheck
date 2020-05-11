import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketCheckTest {
    @Test
    void testBracket1() {
        String expression = "s * (s – a) * (s – b) * (s – c)";

        boolean result = BracketCheck.checkBracket(expression);
        assertTrue(result);
    }

    @Test
    void testBracket2() {
        String expression = "(– b + (b2 – 4*a*c)^0.5) / 2*a";

        boolean result = BracketCheck.checkBracket(expression);
        assertTrue(result);
    }

    @Test
    void testBracket3() {
        String expression = "s * (s – a) * (s – b * (s – c)";

        boolean result = BracketCheck.checkBracket(expression);
        assertFalse(result);
    }

    @Test
    void testBracket4() {
        String expression = "s * (s – a) * s – b) * (s – c)";

        boolean result = BracketCheck.checkBracket(expression);
        assertFalse(result);
    }

    @Test
    void testBracket5() {
        String expression = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";

        boolean result = BracketCheck.checkBracket(expression);
        assertTrue(result);
    }

    @Test
    void testBracket6() {
        String expression = "– b + ((((b^2 – 4*a*c)^(0.5/ 2*a))";

        boolean result = BracketCheck.checkBracket(expression);
        assertFalse(result);
    }

    @Test
    void testBracket7() {
        String expression = "b^2 – )(4*a*c)^(0.5/ 2*a)(";

        boolean result = BracketCheck.checkBracket(expression);
        assertFalse(result);
    }

    @Test
    void testBracket8() {
        String expression = "(b^2 – 4*a*c + ())^(0.5/ 2*a)";

        boolean result = BracketCheck.checkBracket(expression);
        assertFalse(result);
    }

    @Test
    void testBracket9() {
        String expression = "b^2 – )(4*a*c)^(0.5/ 2*a)";

        boolean result = BracketCheck.checkBracket(expression);
        assertFalse(result);
    }

}