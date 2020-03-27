package Stack;

/**
 * @author Honghan Zhu
 * @leetcode 402
 * @grade medium
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";
        int len = num.length() - k;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            while(builder.length() > 0 && k > 0 && builder.charAt(builder.length() - 1) > num.charAt(i)){
                builder.deleteCharAt(builder.length() - 1);
                k -= 1;
            }
            builder.append(num.charAt(i));
        }
        String res = builder.substring(0, len);
        int s = 0;
        for (; s < res.length(); s++) {
            if (res.charAt(s) != '0')
                break;
        }
        res = res.substring(s, res.length());
        return res.length() == 0 ? "0" : res;
    }
}
