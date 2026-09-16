/**
 * Bai 5: Kiem tra n co phai la so nguyen to hay khong.
 *
 * Cac loai nhanh:
 *   - Nhanh dieu kien: phan loai n < 2, n bang 2, n chan, ...
 *   - Vong lap: duyet u le tu 3 den sqrt(n)
 *   - Ngoai le: nem IllegalArgumentException neu n < 2 hoac am
 *   - Nhanh tuyen tinh: tra ve true/false
 */
public final class PrimeUtils {

    private PrimeUtils() {
    }

    /**
     * Kiem tra so nguyen to.
     *
     * @param n so nguyen can kiem tra
     * @return true neu n la so nguyen to
     * @throws IllegalArgumentException neu n < 2
     */
    public static boolean isPrime(int n) {
        // --- Ngoai le: n phai >= 2 ---
        if (n < 2) {
            throw new IllegalArgumentException(
                "n phai >= 2 de kiem tra nguyen to, nhan duoc: " + n);
        }

        // --- Nhanh dieu kien: n = 2 ---
        if (n == 2) {
            return true;
        }
        // --- Nhanh dieu kien: n chan (khong nguyen to) ---
        if (n % 2 == 0) {
            return false;
        }

        // --- Vong lap: duyet u le ---
        int limit = (int) Math.sqrt(n);
        for (int i = 3; i <= limit; i += 2) {
            // --- Nhanh dieu kien trong vong lap ---
            if (n % i == 0) {
                return false;
            }
        }
        // --- Nhanh tuyen tinh: la nguyen to ---
        return true;
    }

    /**
     * Liet ke cac so nguyen to tu 2 den n (dung vong lap).
     */
    public static int[] primesUpTo(int n) {
        if (n < 2) {
            return new int[0];
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        int[] primes = new int[count];
        int idx = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes[idx++] = i;
            }
        }
        return primes;
    }
}