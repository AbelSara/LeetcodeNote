package DP;

import java.util.*;

/**
 * @author Honghan Zhu
 * @牛客 购物单
 */
public class ShoppingList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] v = new int[m + 1];
            int[] p = new int[m + 1];
            int[] q = new int[m + 1];
            for (int i = 1; i <= m; i++) {
                v[i] = sc.nextInt();
                p[i] = sc.nextInt();
                q[i] = sc.nextInt();
            }
            int res = calculate(v, p, q, n, m);
            System.out.println(res);
        }
    }

    private static int calculate(int[] v, int[] p, int[] q, int n, int m) {
        int[] dp = new int[n + 1];
        int ans = 0;
        Map<Integer,Integer>[] map = new HashMap[m + 1];
        for (int i = 1; i <= m; i++)
            map[i] = new HashMap<>();

        for (int i = 1; i <= m; i++) {
            if (q[i] == 0) {
                for (int j = n; j >= 0 && j - v[i] >= 0; j -= 10) {
                    if (j - v[i] == 0 || dp[j - v[i]] != 0) {
                        dp[j] = Math.max(dp[j], dp[j - v[i]] + v[i] * p[i]);
                        map[i].put(j, dp[j]);
                    }
                }
            } else {
                int main = q[i];
                Integer[] arr = new Integer[map[main].size()];
                map[main].keySet().toArray(arr);
                Arrays.sort(arr);
                for (int j = arr.length - 1; j >= 0; j--) {
                    if (arr[j] + v[i] <= n && map[main].get(arr[j]) + v[i] * p[i] > dp[arr[j] + v[i]]) {
                        dp[arr[j] + v[i]] = map[main].get(arr[j]) + v[i] * p[i];
                        map[main].put(arr[j] + v[i], dp[arr[j] + v[i]]);
                    }
                }
            }
            for(int j = 0; j <= n; j++){
                if(dp[j]!=0){
                    System.out.print(j + ":" + dp[j] +" ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i <= n; i++)
            ans = Math.max(ans, dp[i]);
        System.out.println(ans);
        return ans;
    }
}


