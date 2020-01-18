package StringPack;

/**
 * @Author Honghan Zhu
 * @leetcode 43
 * @grade medium
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int[] res = new int[n1.length + n2.length];
        int end = res.length - 1;
        for (int i = n1.length - 1; i >= 0; --i, --end) {
            for (int j = n2.length - 1, k = end; j >= 0; --j, --k) {
                int tmp = (n1[i] - '0') * (n2[j] - '0') + res[k];
                res[k] = tmp % 10;
                res[k - 1] += tmp / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int start;
        for (start = 0; start < res.length; ++start) {
            if (res[start] != 0)
                break;
        }
        while (start < res.length) {
            sb.append(res[start++]);
        }
        if (sb.length() == 0)
            sb.append(0);
        return sb.toString();
    }
}
