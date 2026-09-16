import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GCDUtilsTest {

    @Test
    @DisplayName("gcd: vong lap Euclid")
    void gcdValid() {
        assertEquals(1, GCDUtils.gcd(17, 13));
        assertEquals(6, GCDUtils.gcd(54, 24));
        assertEquals(5, GCDUtils.gcd(5, 5));
        assertEquals(7, GCDUtils.gcd(7, 14));
        assertEquals(13, GCDUtils.gcd(13, 26));
    }

    @Test
    @DisplayName("gcd: so am hoac khong nem ngoai le")
    void gcdInvalid() {
        assertThrows(IllegalArgumentException.class, () -> GCDUtils.gcd(0, 5));
        assertThrows(IllegalArgumentException.class, () -> GCDUtils.gcd(5, 0));
        assertThrows(IllegalArgumentException.class, () -> GCDUtils.gcd(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> GCDUtils.gcd(5, -3));
    }

    @Test
    @DisplayName("gcdRecursive: tuong tu vong lap")
    void gcdRecursive() {
        assertEquals(6, GCDUtils.gcdRecursive(54, 24));
        assertEquals(1, GCDUtils.gcdRecursive(17, 13));
    }

    @Test
    @DisplayName("gcdRecursive: dau vao khong hop le")
    void gcdRecursiveInvalid() {
        assertThrows(IllegalArgumentException.class, () -> GCDUtils.gcdRecursive(0, 5));
        assertThrows(IllegalArgumentException.class, () -> GCDUtils.gcdRecursive(-1, 5));
        // b < 0 phai nem ngoai le (truong hop sau khi valid a)
        assertThrows(IllegalArgumentException.class, () -> GCDUtils.gcdRecursive(5, -1));
    }
}