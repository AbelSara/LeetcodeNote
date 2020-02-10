package Mathematics;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Honghan Zhu
 * @leetcode 166
 * @grade medium
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        boolean negative = false;
        if ((numerator < 0 && denominator > 0)
                || (numerator > 0 && denominator < 0))
            negative = true;
        long num = Math.abs((long) numerator);
        long deno = Math.abs((long) denominator);
        StringBuilder builder = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        if (num >= deno) {
            builder.append(num / deno);
            if (num % deno != 0) {
                builder.append('.');
                generate(num % deno, deno, builder, map);
            }
        } else {
            builder.append(0);
            builder.append('.');
            generate(num, deno, builder, map);
        }
        if (negative)
            builder.insert(0, '-');
        return builder.toString();
    }

    private void generate(long numerator, long denominator, StringBuilder builder, Map<Long, Integer> map) {
        if (numerator == 0) return;
        if (map.containsKey(numerator)) {
            builder.insert((int) map.get(numerator), '(');
            builder.append(')');
            return;
        }
        map.put(numerator, builder.length());
        long tmp = numerator * 10;
        if (tmp < denominator) {
            builder.append(0);
            generate(tmp, denominator, builder, map);
            return;
        }
        long append = tmp / denominator;
        long nextNum = tmp % denominator;
        builder.append(append);
        generate(nextNum, denominator, builder, map);
    }
}
