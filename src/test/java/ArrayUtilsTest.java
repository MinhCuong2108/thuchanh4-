import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrayUtilsTest {

    @Test
    @DisplayName("min int: mang co nhieu phan tu")
    void minIntMany() {
        assertEquals(-5, ArrayUtils.min(new int[]{3, -5, 1, 9}));
        assertEquals(1, ArrayUtils.min(new int[]{1, 1, 1}));
        assertEquals(7, ArrayUtils.min(new int[]{7}));
    }

    @Test
    @DisplayName("min int: mang null")
    void minIntNull() {
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.min((int[]) null));
    }

    @Test
    @DisplayName("min int: mang rong")
    void minIntEmpty() {
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.min(new int[0]));
    }

    @Test
    @DisplayName("min double: hop le")
    void minDoubleValid() {
        assertEquals(-2.5, ArrayUtils.min(new double[]{1.0, -2.5, 3.0}), 1e-9);
        assertEquals(5.0, ArrayUtils.min(new double[]{5.0}), 1e-9);
    }

    @Test
    @DisplayName("min double: null va rong")
    void minDoubleInvalid() {
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.min((double[]) null));
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.min(new double[0]));
    }

    @Test
    @DisplayName("min double: phan tu NaN / vo cuc")
    void minDoubleNaN() {
        assertThrows(IllegalArgumentException.class,
            () -> ArrayUtils.min(new double[]{1.0, Double.NaN}));
        assertThrows(IllegalArgumentException.class,
            () -> ArrayUtils.min(new double[]{1.0, Double.POSITIVE_INFINITY}));
    }
}