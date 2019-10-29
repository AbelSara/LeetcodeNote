package StringPack;

/**
 * @author Honghan Zhu
 * @leetcode 12
 * @grade medium
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int prices[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String tag[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < prices.length; i++) {
            if (num / prices[i] != 0) {
                for (int j = 0; j < num / prices[i]; j++) {
                    result.append(tag[i]);
                }
                num = num % prices[i];
            }
        }
        return result.toString();
    }
}
