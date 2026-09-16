/**
 * Bai 1: Tinh chu vi va dien tich hinh tron.
 *
 * Cac loai nhanh duoc thuc thi:
 *   - Nhanh tuyen tinh (linear): tra ve gia tri tinh toan
 *   - Nhanh dieu kien (conditional): kiem tra ban kinh hop le
 *   - Vong lap (loop): khong su dung (giai thich trong javadoc cua ham)
 *   - Ngoai le (exception): nem IllegalArgumentException khi ban kinh am hoac khong hop le
 */
public final class CircleUtils {

    private CircleUtils() {
        // utility class, khong cho phep khoi tao
    }

    /**
     * Tinh chu vi hinh tron.
     *
     * @param r ban kinh (r > 0)
     * @return chu vi = 2 * PI * r
     * @throws IllegalArgumentException neu r khong hop le (r <= 0 hoac NaN)
     */
    public static double perimeter(double r) {
        validateRadius(r); // --- Nhanh dieu kien + ngoai le ---
        // --- Nhanh tuyen tinh (linear branch) ---
        return 2.0 * Math.PI * r;
    }

    /**
     * Tinh dien tich hinh tron.
     *
     * @param r ban kinh (r > 0)
     * @return dien tich = PI * r * r
     * @throws IllegalArgumentException neu r khong hop le
     */
    public static double area(double r) {
        validateRadius(r); // --- Nhanh dieu kien + ngoai le ---
        // --- Nhanh tuyen tinh (linear branch) ---
        return Math.PI * r * r;
    }

    /**
     * Kiem tra ban kinh hop le. Tach rieng de cac nhanh dieu kien deu
     * co the duoc kiem thu (100% branch coverage).
     */
    private static void validateRadius(double r) {
        // --- Nhanh dieu kien (conditional branch) ---
        if (Double.isNaN(r) || Double.isInfinite(r) || r <= 0.0) {
            // --- Ngoai le (exception handling) ---
            throw new IllegalArgumentException(
                "Ban kinh phai la so thuc duong hop le, nhan duoc: " + r);
        }
    }

    /*
     * Ghi chu: Bai tap nay MINH HOA cac loai nhanh, nhung khong nhat thiet
     * moi ham phai co day du ca 4 loai. Vong lap khong xuat hien trong bai 1
     * vi cong thuc tinh chu vi / dien tich la cong thuc truc tiep.
     */
}