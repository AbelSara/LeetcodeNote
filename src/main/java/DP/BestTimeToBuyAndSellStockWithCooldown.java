package DP;

/**
 * @Author Honghan Zhu
 * @leetcode 309
 * @grade medium
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] hold = new int[len];
        int[] sold = new int[len];
        int[] rest = new int[len];
        hold[0] -= prices[0];
        for (int i = 1; i < len; i++) {
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i]);
            sold[i] = Math.max(hold[i - 1] + prices[i], sold[i]);
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
        }
        return Math.max(sold[len - 1], Math.max(hold[len - 1], rest[len - 1]));
    }
}
