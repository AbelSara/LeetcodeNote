package Mathematics;

/**
 * @author Honghan Zhu
 * @leetcode 69
 * @grade easy
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

    public int mySqrt2(int x) {
        if(x < 2)
            return x;
        double pre = 1.0;
        double cur = 0.0;
        while(Math.abs(pre - cur) >= 1.0){
            cur = pre / 2 + x / (pre * 2);
        }
        return (int)cur;
    }
}
