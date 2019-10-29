package StringPack;

/**
 * @author Honghan Zhu
 * @leetcode 8
 * @grade medium
 */
public class StringToInteger {
    public int myAtoi(String str) {
        boolean isNegative = false;
        long result = Long.MAX_VALUE;
        boolean sequence = false;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case ' ':
                    if (result != Long.MAX_VALUE) {
                        return isNegative ? -(int) result : (int) result;
                    }
                    sequence = false;
                    break;
                case '-':
                    if(result!=Long.MAX_VALUE){
                        return isNegative ? -(int) result : (int) result;
                    }
                    if (sequence) {
                        return 0;
                    }
                    isNegative = true;
                    result = 0;
                    sequence = true;
                    break;
                case '+':
                    if(result!=Long.MAX_VALUE){
                        return isNegative ? -(int) result : (int) result;
                    }
                    if (sequence) {
                        return 0;
                    }
                    isNegative = false;
                    result = 0;
                    sequence = true;
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
                    if (result == Long.MAX_VALUE) {
                        result = 0;
                    }
                    result = result * 10 + (str.charAt(i) - '0');
                    if (result > Integer.MAX_VALUE) {
                        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                    sequence = false;
                    break;
                default:
                    if (result == Long.MAX_VALUE) {
                        return 0;
                    }
                    return isNegative ? -(int) result : (int) result;
            }
        }
        if (Long.MAX_VALUE == result) {
            return 0;
        }
        return isNegative ? -(int) result : (int) result;
    }
}
