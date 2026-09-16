/**
 * Bai 8: Tinh tong S = 1! + 2! + 3! + ... + n! (su dung ham giai thua).
 *
 * Cac loai nhanh:
 *   - Vong lap long (nested loop): tinh giai thua roi cong don
 *   - Nhanh dieu kien: kiem tra n < 1 hoac vuot qua gioi han
 *   - Ngoai le: nem IllegalArgumentException neu n < 1
 *   - Nhanh tuyen tinh: tra ve tong
 */
public final class FactorialSum {

    /** Gioi han de tranh tran so (20! < Long.MAX_VALUE). */
    public static final int MAX_N = 20;

    private FactorialSum() {
    }

    /**
     * Tinh giai thua cua n.
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n phai >= 0, nhan duoc: " + n);
        }
        if (n > MAX_N) {
            throw new IllegalArgumentException(
                "n phai <= " + MAX_N + " de tranh tran long, nhan duoc: " + n);
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Tinh tong S = 1! + 2! + 3! + ... + n!.
     */
    public static long sumOfFactorials(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(
                "n phai >= 1, nhan duoc: " + n);
        }
        if (n > MAX_N) {
            throw new IllegalArgumentException(
                "n phai <= " + MAX_N + " de tranh tran long, nhan duoc: " + n);
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += factorial(i);
        }
        return sum;
    }
}