import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tap test rieng cho cac loai nhanh:
 *   - Linear branch
 *   - Conditional branch
 *   - Loop
 *   - Exception handling
 *
 * Moi nhom @Nested tap trung vao mot loai nhanh cu the.
 */
class WhiteBoxCoverageTest {

    @Nested
    @DisplayName("Nhanh tuyen tinh (Linear branch)")
    class LinearBranch {
        @Test
        void perimeterValid() {
            assertEquals(2 * Math.PI, CircleUtils.perimeter(1.0), 1e-9);
        }

        @Test
        void rectangleAreaValid() {
            assertEquals(20.0, RectangleUtils.area(4.0, 5.0), 1e-9);
        }

        @Test
        void sumFactorialsLinear() {
            assertEquals(9, FactorialSum.sumOfFactorials(3));
        }
    }

    @Nested
    @DisplayName("Nhanh dieu kien (Conditional branch)")
    class ConditionalBranch {
        @Test
        void quadraticTwoRoots() {
            assertEquals(2, QuadraticEquation.solve(1, -5, 6).length);
        }

        @Test
        void quadraticDoubleRoot() {
            assertEquals(1, QuadraticEquation.solve(1, -4, 4).length);
        }

        @Test
        void quadraticNoRoot() {
            assertEquals(0, QuadraticEquation.solve(1, 1, 1).length);
        }

        @Test
        void alternatingOddN() {
            assertEquals(2, AlternatingSum.alternatingSum(3));
        }

        @Test
        void alternatingEvenN() {
            assertEquals(-2, AlternatingSum.alternatingSum(4));
        }

        @Test
        void primeTwo() {
            assertTrue(PrimeUtils.isPrime(2));
        }

        @Test
        void primeEvenComposite() {
            assertFalse(PrimeUtils.isPrime(4));
        }
    }

    @Nested
    @DisplayName("Vong lap (Loop)")
    class LoopBranch {
        @Test
        void minArrayLoop() {
            assertEquals(-10, ArrayUtils.min(new int[]{3, -10, 5, 8}));
        }

        @Test
        void sumFactorialLoop() {
            assertEquals(153, FactorialSum.sumOfFactorials(5));
        }

        @Test
        void gcdLoop() {
            assertEquals(6, GCDUtils.gcd(54, 24));
        }

        @Test
        void primeOddLoop() {
            assertTrue(PrimeUtils.isPrime(29));
            assertFalse(PrimeUtils.isPrime(49));
        }

        @Test
        void primesUpToLoop() {
            int[] p = PrimeUtils.primesUpTo(20);
            assertEquals(8, p.length);
            assertEquals(19, p[p.length - 1]);
        }
    }

    @Nested
    @DisplayName("Ngoai le (Exception handling)")
    class ExceptionHandling {
        @Test
        void circleZeroRadius() {
            assertThrows(IllegalArgumentException.class, () -> CircleUtils.perimeter(0));
        }

        @Test
        void rectangleNegativeSide() {
            assertThrows(IllegalArgumentException.class, () -> RectangleUtils.area(-1, 5));
        }

        @Test
        void quadraticZeroA() {
            assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
        }

        @Test
        void arrayNull() {
            assertThrows(IllegalArgumentException.class, () -> ArrayUtils.min((int[]) null));
        }

        @Test
        void arrayEmpty() {
            assertThrows(IllegalArgumentException.class, () -> ArrayUtils.min(new int[0]));
        }

        @Test
        void primeTooSmall() {
            assertThrows(IllegalArgumentException.class, () -> PrimeUtils.isPrime(1));
        }

        @Test
        void alternatingZeroN() {
            assertThrows(IllegalArgumentException.class, () -> AlternatingSum.alternatingSum(0));
        }

        @Test
        void gcdNegative() {
            assertThrows(IllegalArgumentException.class, () -> GCDUtils.gcd(-1, 5));
        }

        @Test
        void factorialNegative() {
            assertThrows(IllegalArgumentException.class, () -> FactorialSum.factorial(-1));
        }

        @Test
        void sumFactorialZero() {
            assertThrows(IllegalArgumentException.class, () -> FactorialSum.sumOfFactorials(0));
        }
    }
}