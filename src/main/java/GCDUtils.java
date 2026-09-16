/**
 * Bai 7: Tim UCLN (GCD) cua a va b bang thuat toan Euclid.
 *
 * Cac loai nhanh:
 *   - Nhanh dieu kien: kiem tra dau vao am / bang 0
 *   - Vong lap: lap chung cua Euclid
 *   - Ngoai le: nem IllegalArgumentException neu ca hai cung 0, hoac am
 *   - Nhanh tuyen tinh: tra ve ket qua
 */
public final class GCDUtils {

    private GCDUtils() {
    }

    /**
     * Tinh UCLN cua a va b bang vong lap Euclid.
     *
     * @param a so nguyen (a > 0)
     * @param b so nguyen (b > 0)
     * @return UCLN
     * @throws IllegalArgumentException neu a hoac b <= 0
     */
    public static int gcd(int a, int b) {
        // --- Ngoai le ---
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException(
                "a va b phai duong, nhan duoc: a=" + a + ", b=" + b);
        }

        // --- Vong lap Euclid ---
        int x = a, y = b;
        while (y != 0) {
            // --- Nhanh dieu kien ---
            int r = x % y;
            x = y;
            y = r;
        }
        // --- Nhanh tuyen tinh ---
        return x;
    }

    /**
     * Phien ban de quy (bonus).
     *
     * Luu y: b co the dat gia tri 0 trong qua trinh de quy (truong hop co so).
     * Do do validate cho phep b == 0 nhung b phai >= 0; chi throw khi am.
     */
    public static int gcdRecursive(int a, int b) {
        if (a <= 0 || b < 0) {
            throw new IllegalArgumentException(
                "a phai duong va b khong am, nhan duoc: a=" + a + ", b=" + b);
        }
        // --- Nhanh dieu kien (base case) ---
        if (b == 0) {
            return a;
        }
        return gcdRecursive(b, a % b);
    }
}