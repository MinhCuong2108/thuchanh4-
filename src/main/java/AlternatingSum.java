/**
 * Bai 6: Tinh tong S = 1 - 2 + 3 - 4 + ... + n.
 *
 * Cac loai nhanh:
 *   - Nhanh dieu kien: n chan hay n le (dau cua so cuoi)
 *   - Vong lap: tinh tong
 *   - Ngoai le: nem IllegalArgumentException neu n < 1
 *   - Nhanh tuyen tinh: tra ve ket qua
 */
public final class AlternatingSum {

    private AlternatingSum() {
    }

    /**
     * Tinh tong S = 1 - 2 + 3 - 4 + ... + n.
     *
     * @param n so nguyen >= 1
     * @return gia tri tong
     * @throws IllegalArgumentException neu n < 1
     */
    public static long alternatingSum(int n) {
        // --- Ngoai le ---
        if (n < 1) {
            throw new IllegalArgumentException(
                "n phai >= 1, nhan duoc: " + n);
        }

        // --- Vong lap tinh tong ---
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            // --- Nhanh dieu kien: chan thi tru, le thi cong ---
            if (i % 2 == 0) {
                sum -= i;
            } else {
                sum += i;
            }
        }
        // --- Nhanh tuyen tinh ---
        return sum;
    }

    /**
     * Cong thuc dong: neu n chan, S = -n/2; neu n le, S = (n+1)/2.
     * (bonus, giup test doc ket qua)
     */
    public static long formula(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n phai >= 1");
        }
        // --- Nhanh dieu kien ---
        if (n % 2 == 0) {
            return -(n / 2);
        }
        return (n + 1) / 2;
    }
}