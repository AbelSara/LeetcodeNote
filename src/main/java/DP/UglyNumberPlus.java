package DP;

/**
 * Created by Albert on 2020/3/10.
 */
public class UglyNumberPlus {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int count = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        while (count < n) {
            int tmp = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            dp[++count] = tmp;
            if (tmp == dp[i2] * 2)
                i2++;
            if (tmp == dp[i3] * 3)
                i3++;
            if (tmp == dp[i5] * 5)
                i5++;
        }
        for (int i = 1; i < dp.length; i++)
            System.out.println(dp[i]);
        return dp[n];
    }
}
