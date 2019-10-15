package Mathematics;

/**
 * @author Honghan Zhu
 * @leetcode 9
 * @grade easy
 */
public class Palindrome {
    public static boolean isPalindrome(int x) {
        if (x >= 0 && x < 10) return true;
        else if (x < 0) return false;
        String originStr = String.valueOf(x);
        for (int i = 0, j = originStr.length() - 1; i < j; i++, j--) {
            if (originStr.charAt(i) != originStr.charAt(j)) return false;
        }
        return true;
    }
}
