package Mathematics;

/**
 * @Author Honghan Zhu
 * @leetcode 50
 * @grade medium
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        double res = pow(x, n);
        return n > 0 ? res : 1.0 / res;
    }

    private double pow(double x, int n) {
        if (Math.abs(n) == 1) {
            return x;
        }
        double res = 1.0;
        if (n % 2 == 0) {
            double tmp = pow(x, n / 2);
            res *= tmp * tmp;
        } else {
            double tmp = pow(x, n / 2);
            res *= tmp * tmp;
            res *= x;
        }
        return res;
    }
}
