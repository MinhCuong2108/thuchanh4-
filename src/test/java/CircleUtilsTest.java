import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CircleUtilsTest {

    @Test
    @DisplayName("perimeter: ban kinh hop le")
    void perimeterValid() {
        assertEquals(2 * Math.PI, CircleUtils.perimeter(1.0), 1e-9);
        assertEquals(0, CircleUtils.perimeter(Double.MIN_VALUE), 1e-9);
    }

    @Test
    @DisplayName("area: ban kinh hop le")
    void areaValid() {
        assertEquals(Math.PI, CircleUtils.area(1.0), 1e-9);
        assertEquals(4 * Math.PI, CircleUtils.area(2.0), 1e-9);
    }

    @Test
    @DisplayName("perimeter: ban kinh khong hop le nem ngoai le")
    void perimeterInvalid() {
        assertThrows(IllegalArgumentException.class, () -> CircleUtils.perimeter(0));
        assertThrows(IllegalArgumentException.class, () -> CircleUtils.perimeter(-1));
        assertThrows(IllegalArgumentException.class, () -> CircleUtils.perimeter(Double.NaN));
        assertThrows(IllegalArgumentException.class, () -> CircleUtils.perimeter(Double.POSITIVE_INFINITY));
    }

    @Test
    @DisplayName("area: ban kinh khong hop le nem ngoai le")
    void areaInvalid() {
        assertThrows(IllegalArgumentException.class, () -> CircleUtils.area(0));
        assertThrows(IllegalArgumentException.class, () -> CircleUtils.area(-2.5));
        assertThrows(IllegalArgumentException.class, () -> CircleUtils.area(Double.NaN));
        assertThrows(IllegalArgumentException.class, () -> CircleUtils.area(Double.NEGATIVE_INFINITY));
    }
}