package StringPack;

/**
 * @author Honghan Zhu
 * @leetcode 8
 * @grade medium
 */
public class StringToInteger {
    public int myAtoi(String str) {
        int len = str.length();
        boolean isNegative = false;
        long result = Long.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            switch (str.charAt(i)) {
                case ' ':
                    if (result != Long.MAX_VALUE) return (int) result;
                    break;
                case '-':
                    isNegative = true;
                case '+':
                    if (result != Long.MAX_VALUE) return (int) result;
                    isNegative = str.charAt(i) == '-' ? true : false;
                    result = 0;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if (result == Long.MAX_VALUE) result = 0;
                    result = isNegative ? result * 10 - (str.charAt(i) - 48) : result * 10 + (str.charAt(i) - 48);
                    if (result >= Integer.MAX_VALUE || result <= Integer.MIN_VALUE)
                        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    break;
                default:
                    return result == Long.MAX_VALUE ? 0 : (int) result;
            }
        }
        return result == Long.MAX_VALUE ? 0 : (int) result;
    }
}
