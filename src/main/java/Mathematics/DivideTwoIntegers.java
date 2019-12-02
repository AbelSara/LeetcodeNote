package Mathematics;

/**
 * @author Honghan Zhu
 * @leetcode 29
 * @grade medium
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if (divisor == -1) return -dividend;
        else if (divisor == 1) return dividend;
        int flag = 0; // 0:++||--; 1:+-; 2:-+
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0)
            flag = 0;
        else if (dividend > 0 && divisor < 0)
            flag = 1;
        else if (dividend < 0 && divisor > 0)
            flag = 2;
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);
        int k = 0;
        for (long d = divisorL, i = 1; dividendL >= divisorL; d *= 2, i *= 2) {
            if (dividendL < d) {
                i = 1;
                d = divisorL;
            }
            dividendL -= d;
            k += i;
        }

        switch (flag) {
            case 1:
            case 2:
                k = -k;
                break;
        }
        return k;
    }
}
