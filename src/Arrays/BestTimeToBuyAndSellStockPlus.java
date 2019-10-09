package Arrays;

/**
 * Author:Honghan Zhu
 * leetcode:122
 * Grade:easy
 */
public class BestTimeToBuyAndSellStockPlus {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}
