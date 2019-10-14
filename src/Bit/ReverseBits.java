package Bit;

/**
 * Author:Honghan Zhu
 * leetcode:190
 * Grade:easy
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n >> 1;
            temp = temp & 1;
            temp = temp << (31 - i);
            result = result | temp;
        }
        return result;
    }
}
