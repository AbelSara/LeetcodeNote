package mathematics;

/**
 * Author:Honghan Zhu
 * leetcode:69
 * Grade:easy
 */
public class Sqrt {
    public int mySqrt(int x) {
        long low = 0, high = x / 2 + 1;
        while (low < high) {
            long mid = (high + low + 1) / 2;
            long temp = mid * mid;
            if (temp > x) high = mid - 1;
            else if (temp < x) low = mid;
            else if (temp == x) return (int) mid;
        }
        return (int) low;
    }
}
