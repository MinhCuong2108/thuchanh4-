import java.util.Objects;

/**
 * Bai 3: Giai phuong trinh bac 2: a*x^2 + b*x + c = 0.
 *
 * Tra ve mang gom 0, 1 hoac 2 nghiem thuc:
 *   - delta < 0  -> mang rong (0 nghiem)
 *   - delta == 0 -> 1 nghiem kep
 *   - delta > 0  -> 2 nghiem phan biet
 *
 * Cac loai nhanh:
 *   - Nhanh dieu kien (conditional): phan loai delta
 *   - Nhanh tuyen tinh (linear): tra ve mang theo truong hop
 *   - Ngoai le: nem IllegalArgumentException neu a == 0 (khong con la bac 2)
 */
public final class QuadraticEquation {

    private QuadraticEquation() {
    }

    /**
     * Giai phuong trinh bac 2.
     *
     * @param a he so a (a != 0)
     * @param b he so b
     * @param c he so c
     * @return mang chua 0..2 nghiem thuc
     */
    public static double[] solve(double a, double b, double c) {
        // --- Ngoai le (exception handling): a phai khac 0 ---
        if (a == 0.0) {
            throw new IllegalArgumentException(
                "He so a phai khac 0 de la phuong trinh bac 2");
        }

        // Tinh delta (nhanh tuyen tinh)
        double delta = b * b - 4.0 * a * c;

        // --- Nhanh dieu kien (conditional branch): phan loai delta ---
        if (delta < 0.0) {
            // Khong co nghiem thuc (nhanh tuyen tinh tra ve mang rong)
            return new double[0];
        } else if (delta == 0.0) {
            // Nghiem kep (nhanh tuyen tinh tra ve 1 nghiem)
            double x = -b / (2.0 * a);
            return new double[]{x};
        } else {
            // 2 nghiem phan biet (nhanh tuyen tinh tra ve 2 nghiem)
            double sqrtDelta = Math.sqrt(delta);
            double x1 = (-b + sqrtDelta) / (2.0 * a);
            double x2 = (-b - sqrtDelta) / (2.0 * a);
            return new double[]{x1, x2};
        }
    }

    /**
     * Phien ban tra ve chuoi mo ta (giup test doc ket qua).
     */
    public static String describe(double a, double b, double c) {
        Objects.requireNonNull(a + "", "a khong duoc null");
        double[] roots = solve(a, b, c);
        if (roots.length == 0) return "Vo nghiem";
        if (roots.length == 1) return "Nghiem kep x = " + roots[0];
        return "Hai nghiem x1 = " + roots[0] + ", x2 = " + roots[1];
    }
}