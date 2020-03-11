package DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                p[i] *= v[i];
            }
            int res = calculate(v, p, q, n, m);
            System.out.println(res);
        }
    }

    private static int calculate(int[] v, int[] p, int[] q, int n, int m) {
        int[] dp = new int[n + 1];
        int ans = 0;
        List<Integer>[] child = new ArrayList[m + 1];
        for (int i = 1; i <= m; i++) {
            child[i] = new ArrayList<>();
            if (q[i] != 0)
                child[q[i]].add(i);
        }

        for (int i = 1; i <= m; i++) {
            if (q[i] == 0) {
                List<Entry> list = cal(v, p, i, child);
                int[] dpTmp = new int[n + 1];
                for (int k = 0; k < list.size(); k++) {
                    for (int j = list.get(k).getKey(); j <= n; j += 10) {
                        dpTmp[j] = Math.max(dpTmp[j], dp[j - list.get(k).getKey()] + list.get(k).getVal());
                    }
                }
                dp = dpTmp;
            }
        }
        for (int i = 0; i <= n; i++)
            ans = Math.max(dp[i], ans);
        return ans;
    }

    private static List<Entry> cal(int[] v, int[] p, int idx, List<Integer>[] child) {
        List<Entry> list = new ArrayList<>();
        list.add(new Entry(0, 0));
        list.add(new Entry(v[idx], p[idx]));
        for (int i = 0; i < child[idx].size(); i++) {
            int key = v[idx] + v[child[idx].get(i)];
            int val = p[idx] + p[child[idx].get(i)];
            list.add(new Entry(key,val));
        }
        for (int i = 0; i < child[idx].size(); i++) {
            for (int j = i + 1; j < child[idx].size(); j++) {
                int key = v[idx] + v[child[idx].get(i)] + v[child[idx].get(j)];
                int val = p[idx] + p[child[idx].get(i)] + p[child[idx].get(j)];
                list.add(new Entry(key, val));
            }
        }
        return list;
    }

    static class Entry {
        int key;
        int val;

        Entry(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public int getVal() {
            return val;
        }
    }
}


