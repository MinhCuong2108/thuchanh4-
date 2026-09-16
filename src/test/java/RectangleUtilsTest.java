import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RectangleUtilsTest {

    @Test
    @DisplayName("area: hai canh duong")
    void areaValid() {
        assertEquals(6.0, RectangleUtils.area(2.0, 3.0), 1e-9);
        assertEquals(1.0, RectangleUtils.area(1.0, 1.0), 1e-9);
    }

    @Test
    @DisplayName("perimeter: hai canh duong")
    void perimeterValid() {
        assertEquals(10.0, RectangleUtils.perimeter(2.0, 3.0), 1e-9);
    }

    @Test
    @DisplayName("area: chieu rong khong hop le")
    void areaInvalidWidth() {
        assertThrows(IllegalArgumentException.class, () -> RectangleUtils.area(0, 5));
        assertThrows(IllegalArgumentException.class, () -> RectangleUtils.area(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> RectangleUtils.area(Double.NaN, 5));
        assertThrows(IllegalArgumentException.class, () -> RectangleUtils.area(Double.POSITIVE_INFINITY, 5));
    }

    @Test
    @DisplayName("area: chieu dai khong hop le")
    void areaInvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> RectangleUtils.area(5, 0));
        assertThrows(IllegalArgumentException.class, () -> RectangleUtils.area(5, -1));
        assertThrows(IllegalArgumentException.class, () -> RectangleUtils.area(5, Double.NaN));
        assertThrows(IllegalArgumentException.class, () -> RectangleUtils.area(5, Double.NEGATIVE_INFINITY));
    }

    @Test
    @DisplayName("perimeter: dau vao khong hop le")
    void perimeterInvalid() {
        assertThrows(IllegalArgumentException.class, () -> RectangleUtils.perimeter(0, 5));
        assertThrows(IllegalArgumentException.class, () -> RectangleUtils.perimeter(5, -1));
        assertThrows(IllegalArgumentException.class, () -> RectangleUtils.perimeter(Double.NaN, 5));
        assertThrows(IllegalArgumentException.class, () -> RectangleUtils.perimeter(Double.POSITIVE_INFINITY, 5));
    }
}