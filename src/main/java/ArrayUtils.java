/**
 * Bai 4: Tim so nho nhat cua mot mang.
 *
 * Cac loai nhanh:
 *   - Nhanh dieu kien: kiem tra mang rong / null
 *   - Vong lap: duyet mang tim min
 *   - Ngoai le: nem IllegalArgumentException neu mang rong hoac null
 *   - Nhanh tuyen tinh: tra ve gia tri min
 */
public final class ArrayUtils {

    private ArrayUtils() {
    }

    /**
     * Tim gia tri nho nhat cua mang so nguyen.
     *
     * @param arr mang dau vao
     * @return gia tri nho nhat
     * @throws IllegalArgumentException neu arr null hoac rong
     */
    public static int min(int[] arr) {
        // --- Nhanh dieu kien: kiem tra null ---
        if (arr == null) {
            throw new IllegalArgumentException("Mang khong duoc null");
        }
        // --- Nhanh dieu kien: kiem tra rong ---
        if (arr.length == 0) {
            throw new IllegalArgumentException("Mang khong duoc rong");
        }

        // --- Vong lap (loop): tim min ---
        int minVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // --- Nhanh dieu kien trong vong lap ---
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }
        // --- Nhanh tuyen tinh: tra ve gia tri ---
        return minVal;
    }

    /**
     * Phien ban double de tap them cac truong hop.
     */
    public static double min(double[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Mang khong duoc null");
        }
        if (arr.length == 0) {
            throw new IllegalArgumentException("Mang khong duoc rong");
        }
        double minVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Double.isNaN(arr[i]) || Double.isInfinite(arr[i])) {
                throw new IllegalArgumentException("Phan tu khong hop le: " + arr[i]);
            }
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }
        return minVal;
    }
}