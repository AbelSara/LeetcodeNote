package Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Honghan Zhu
 * @leetcode 870
 * @grade medium
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        int[] tmpA = Arrays.copyOf(A, A.length);
        int[] tmpB = Arrays.copyOf(B, B.length);
        Arrays.sort(tmpA);
        Arrays.sort(tmpB);
        int[] res = new int[A.length];
        int[] tmp = new int[A.length];
        int len = 0;
        Map<Integer, LinkedList<Integer>> map = new HashMap();
        for(int i = 0; i < B.length; ++i)
            map.put(B[i], new LinkedList());

        for(int i = 0, j = 0; i < tmpA.length; ++i){
            if(tmpA[i] <= tmpB[j]){
                tmp[len++] = tmpA[i];
            }else{
                map.get(tmpB[j]).add(tmpA[i]);
                ++j;
            }
        }

        int j = 0;
        for(int i = 0; i < B.length; ++i){
            LinkedList<Integer> list = map.get(B[i]);
            if(list.size() > 0){
                res[i] = list.removeFirst();
            }else{
                res[i] = tmp[j++];
            }
        }

        return res;
    }
}
