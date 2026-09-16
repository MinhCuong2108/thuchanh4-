import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FactorialSumTest {

    @Test
    @DisplayName("factorial: gia tri dung")
    void factorialValid() {
        assertEquals(1, FactorialSum.factorial(0));
        assertEquals(1, FactorialSum.factorial(1));
        assertEquals(2, FactorialSum.factorial(2));
        assertEquals(6, FactorialSum.factorial(3));
        assertEquals(24, FactorialSum.factorial(4));
        assertEquals(120, FactorialSum.factorial(5));
        assertEquals(2432902008176640000L, FactorialSum.factorial(20));
    }

    @Test
    @DisplayName("factorial: am hoac vuot qua MAX_N")
    void factorialInvalid() {
        assertThrows(IllegalArgumentException.class, () -> FactorialSum.factorial(-1));
        assertThrows(IllegalArgumentException.class, () -> FactorialSum.factorial(21));
    }

    @Test
    @DisplayName("sumOfFactorials: gia tri dung")
    void sumValid() {
        // 1! = 1
        assertEquals(1, FactorialSum.sumOfFactorials(1));
        // 1! + 2! = 3
        assertEquals(3, FactorialSum.sumOfFactorials(2));
        // 1! + 2! + 3! = 9
        assertEquals(9, FactorialSum.sumOfFactorials(3));
        // 1!+2!+3!+4! = 33
        assertEquals(33, FactorialSum.sumOfFactorials(4));
    }

    @Test
    @DisplayName("sumOfFactorials: dau vao khong hop le")
    void sumInvalid() {
        assertThrows(IllegalArgumentException.class, () -> FactorialSum.sumOfFactorials(0));
        assertThrows(IllegalArgumentException.class, () -> FactorialSum.sumOfFactorials(-1));
        assertThrows(IllegalArgumentException.class, () -> FactorialSum.sumOfFactorials(21));
    }
}