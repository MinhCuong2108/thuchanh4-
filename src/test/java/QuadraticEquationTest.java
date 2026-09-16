import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuadraticEquationTest {

    @Test
    @DisplayName("delta > 0: hai nghiem phan biet")
    void twoRoots() {
        // x^2 - 5x + 6 = 0 -> x1=3, x2=2
        double[] roots = QuadraticEquation.solve(1, -5, 6);
        assertArrayEquals(new double[]{3.0, 2.0}, roots, 1e-9);
    }

    @Test
    @DisplayName("delta == 0: nghiem kep")
    void doubleRoot() {
        // x^2 - 4x + 4 = 0 -> x=2
        double[] roots = QuadraticEquation.solve(1, -4, 4);
        assertArrayEquals(new double[]{2.0}, roots, 1e-9);
    }

    @Test
    @DisplayName("delta < 0: vo nghiem")
    void noRealRoots() {
        // x^2 + x + 1 = 0
        double[] roots = QuadraticEquation.solve(1, 1, 1);
        assertEquals(0, roots.length);
    }

    @Test
    @DisplayName("a == 0: nem ngoai le")
    void zeroA() {
        assertThrows(IllegalArgumentException.class,
            () -> QuadraticEquation.solve(0, 1, 1));
    }

    @Test
    @DisplayName("describe: kiem tra chuoi mo ta")
    void describeAllBranches() {
        assertEquals("Hai nghiem x1 = 3.0, x2 = 2.0", QuadraticEquation.describe(1, -5, 6));
        assertEquals("Nghiem kep x = 2.0", QuadraticEquation.describe(1, -4, 4));
        assertEquals("Vo nghiem", QuadraticEquation.describe(1, 1, 1));
    }
}