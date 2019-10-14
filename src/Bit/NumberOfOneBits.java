package Bit;

/**
 * Author:Honghan Zhu
 * leetcode:191
 * Grade:Easy
 */
public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1)
                result++;
        }
        return result;
    }
}
