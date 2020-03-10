package DP;

/**
 * @author Honghan Zhu
 * @leetcode 714
 * @grade medium
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[] sold = new int[len];
        int[] hold = new int[len];
        hold[0] -= prices[0];
        for (int i = 1; i < len; i++) {
            hold[i] = Math.max(hold[i - 1], sold[i - 1] - prices[i]);
            sold[i] = Math.max(sold[i - 1], hold[i - 1] + prices[i] - fee);
        }
        return Math.max(hold[len - 1], sold[len - 1]);
    }
}
