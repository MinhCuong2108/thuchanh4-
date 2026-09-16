import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrimeUtilsTest {

    @Test
    @DisplayName("isPrime: cac so nguyen to nho")
    void primesTrue() {
        assertTrue(PrimeUtils.isPrime(2));
        assertTrue(PrimeUtils.isPrime(3));
        assertTrue(PrimeUtils.isPrime(5));
        assertTrue(PrimeUtils.isPrime(7));
        assertTrue(PrimeUtils.isPrime(11));
        assertTrue(PrimeUtils.isPrime(13));
        assertTrue(PrimeUtils.isPrime(97));
    }

    @Test
    @DisplayName("isPrime: cac so khong nguyen to")
    void primesFalse() {
        assertFalse(PrimeUtils.isPrime(4));
        assertFalse(PrimeUtils.isPrime(9));
        assertFalse(PrimeUtils.isPrime(15));
        assertFalse(PrimeUtils.isPrime(100));
    }

    @Test
    @DisplayName("isPrime: nho hon 2 nem ngoai le")
    void primesInvalid() {
        assertThrows(IllegalArgumentException.class, () -> PrimeUtils.isPrime(0));
        assertThrows(IllegalArgumentException.class, () -> PrimeUtils.isPrime(1));
        assertThrows(IllegalArgumentException.class, () -> PrimeUtils.isPrime(-5));
    }

    @Test
    @DisplayName("primesUpTo: liet ke dung")
    void primesUpTo() {
        assertArrayEquals(new int[]{2, 3, 5, 7}, PrimeUtils.primesUpTo(10));
        assertArrayEquals(new int[]{}, PrimeUtils.primesUpTo(1));
        assertArrayEquals(new int[]{}, PrimeUtils.primesUpTo(-3));
    }
}