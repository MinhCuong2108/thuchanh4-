/**
 * Bai 2: Tinh dien tich hinh chu nhat.
 *
 * Cac loai nhanh:
 *   - Nhanh dieu kien: kiem tra chieu dai, chieu rong hop le
 *   - Nhanh tuyen tinh: tra ve tich
 *   - Ngoai le: nem IllegalArgumentException khi canh am / zero
 *   - Vong lap: khong co (cong thuc tinh truc tiep)
 */
public final class RectangleUtils {

    private RectangleUtils() {
    }

    /**
     * Tinh dien tich hinh chu nhat.
     *
     * @param width  chieu rong (> 0)
     * @param height chieu dai (> 0)
     * @return dien tich = width * height
     * @throws IllegalArgumentException neu mot trong hai canh khong hop le
     */
    public static double area(double width, double height) {
        validateSides(width, height);
        // --- Nhanh tuyen tinh (linear branch) ---
        return width * height;
    }

    /**
     * Tinh chu vi hinh chu nhat (bonus, giup kiem thu nhanh dieu kien).
     */
    public static double perimeter(double width, double height) {
        validateSides(width, height);
        return 2.0 * (width + height);
    }

    /** Kiem tra canh hop le, tach rieng de 100% branch coverage. */
    private static void validateSides(double width, double height) {
        // --- Nhanh dieu kien (conditional branch) ---
        if (Double.isNaN(width) || Double.isInfinite(width) || width <= 0.0) {
            // --- Ngoai le (exception handling) ---
            throw new IllegalArgumentException(
                "Chieu rong phai duong, nhan duoc: " + width);
        }
        if (Double.isNaN(height) || Double.isInfinite(height) || height <= 0.0) {
            // --- Ngoai le (exception handling) ---
            throw new IllegalArgumentException(
                "Chieu dai phai duong, nhan duoc: " + height);
        }
    }
}