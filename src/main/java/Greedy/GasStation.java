package Greedy;

/**
 * @Author Honghan Zhu
 * @leetcode 134
 * @grade medium
 */
public class GasStation {
    //testgit
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int need = 0;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            int delta = gas[i] - cost[i];
            sum += delta;
            if (sum < 0) {
                start = i + 1;
                need += sum;
                sum = 0;
            }
        }
        if (sum + need >= 0)
            return start;
        return -1;
    }
}
