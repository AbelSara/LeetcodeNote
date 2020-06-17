package Mathematics;

/**
 * @author Honghan Zhu
 * @leetcode 1014
 * @grade medium
 */
public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int len = A.length;
        int ans = 0, max = A[0] + 0;
        for(int i = 1; i < len; ++i){
            max = Math.max(max, A[i - 1] + i - 1);
            ans = Math.max(ans, max + A[i] - i);
        }
        return ans;
    }
}
