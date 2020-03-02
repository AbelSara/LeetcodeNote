package Mathematics;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Honghan Zhu
 * @leetcode 202
 * @grade easy
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            String num = String.valueOf(n);
            set.add(n);
            n = 0;
            for (int i = 0; i < num.length(); i++) {
                n += (int) Math.pow(num.charAt(i) - '0', 2);
            }
            if (set.contains(n))
                break;
        }
        return n == 1;
    }
}
