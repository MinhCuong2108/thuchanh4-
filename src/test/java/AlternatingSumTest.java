import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AlternatingSumTest {

    @Test
    @DisplayName("alternatingSum: n le")
    void oddN() {
        // 1 - 2 + 3 = 2
        assertEquals(2, AlternatingSum.alternatingSum(3));
        // 1 - 2 + 3 - 4 + 5 = 3
        assertEquals(3, AlternatingSum.alternatingSum(5));
        assertEquals(1, AlternatingSum.alternatingSum(1));
    }

    @Test
    @DisplayName("alternatingSum: n chan")
    void evenN() {
        // 1 - 2 = -1
        assertEquals(-1, AlternatingSum.alternatingSum(2));
        // 1 - 2 + 3 - 4 = -2
        assertEquals(-2, AlternatingSum.alternatingSum(4));
        // 1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 = -5
        assertEquals(-5, AlternatingSum.alternatingSum(10));
    }

    @Test
    @DisplayName("alternatingSum: n khong hop le")
    void invalidN() {
        assertThrows(IllegalArgumentException.class, () -> AlternatingSum.alternatingSum(0));
        assertThrows(IllegalArgumentException.class, () -> AlternatingSum.alternatingSum(-3));
    }

    @Test
    @DisplayName("formula: n le va n chan")
    void formulaAll() {
        assertEquals(1, AlternatingSum.formula(1));
        assertEquals(-1, AlternatingSum.formula(2));
        assertEquals(2, AlternatingSum.formula(3));
        assertEquals(-5, AlternatingSum.formula(10));
    }

    @Test
    @DisplayName("formula: n khong hop le")
    void formulaInvalid() {
        assertThrows(IllegalArgumentException.class, () -> AlternatingSum.formula(0));
        assertThrows(IllegalArgumentException.class, () -> AlternatingSum.formula(-1));
    }
}