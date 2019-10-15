package Arrays;

import java.util.Arrays;

/**
 * @author: Honghan Zhu
 * @leetcode: 88
 * @grade: easy
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int cpNums1[]= Arrays.copyOf(nums1,m);
        int index=0;
        while (i < m && j < n) {
            if(cpNums1[i]<nums2[j]){
                nums1[index++]=cpNums1[i++];
            }else{
                nums1[index++]=nums2[j++];
            }
        }
        while(i<m){
            nums1[index++]=cpNums1[i++];
        }
        while(j<n){
            nums1[index++]=nums2[j++];
        }
    }
}
