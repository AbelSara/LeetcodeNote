package Arrays;

/**
 * @author: Honghan Zhu
 * @leetcode: 121
 * @grade: easy
 * @method: DP
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minPrice = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minPrice > result) {
                result = prices[i] - minPrice;
            }
            minPrice = minPrice < prices[i] ? minPrice : prices[i];
        }
        return result;
    }
}
