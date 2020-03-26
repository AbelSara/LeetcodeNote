package DP;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Honghan Zhu
 * @leetcode 357
 * @grade medium
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1)
                dp[i] = 9;
            else
                dp[i] = dp[i - 1] * (10 - i + 1);
        }
        int res = 0;
        for (int i = 0; i <= n; i++)
            res += dp[i];
        return res;
    }

    public int countNumbersWithUniqueDigits(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        int res = 0;
        for (int i = 0, thresh = 10; i <= n; i++) {
            res += queue.size();
            Queue<Integer> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int num = queue.poll();
                boolean[] visited = new boolean[10];
                if (num == 0)
                    visited[0] = true;
                else {
                    for (int tmp = num; tmp > 0; tmp /= 10) {
                        visited[tmp % 10] = true;
                    }
                }
                for (int j = 0; j <= 9; j++) {
                    if (!visited[j]) {
                        nextQueue.offer(num * 10 + j);
                    }
                }
            }
            queue = nextQueue;
        }
        return res;
    }
}
