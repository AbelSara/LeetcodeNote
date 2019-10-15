package Mathematics;

/**
 * @author Honghan Zhu
 * @leetcode 171
 * @grade easy
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = s.length() - 1, multiple = 1; i >= 0; i--, multiple *= 26) {
            sum += (s.charAt(i) - 'A' + 1) * multiple;
        }
        return sum;
    }
}
