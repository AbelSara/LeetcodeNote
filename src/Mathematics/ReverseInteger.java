package Mathematics;

/**
 * Author:Honghan Zhu
 * leetcode:7
 * Grade:easy
 */
public class ReverseInteger {
    public static int reverse(int x) {
        if (x < 10 && x > -10) return x;
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }
        long digit = 10;
        for (int temp = x; temp / 10 >= 10; digit *= 10, temp /= 10) ;
        long result = 0;
        while (x > 0) {
            int temp = x % 10;
            result += digit * temp;
            digit /= 10;
            x = x / 10;
        }

        if (true == negative) result = -result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        return (int) result;
    }
}
