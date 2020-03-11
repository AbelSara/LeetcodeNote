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
                p[i] = p[i] * v[i];
            }
            List<List<Integer>> children = new ArrayList<>();
            children.add(new ArrayList<>());
            for (int i = 1; i <= m; i++) {
                children.add(new ArrayList<>());
                if (q[i] > 0) {
                    children.get(q[i]).add(i);
                }
            }
            int res = calculate(v, p, q, n, m, children);
            System.out.println(res);
        }
    }

    private static List<Pair<Integer, Integer>> cal(int idx, int[] v, int[] p, List<List<Integer>> children) {
        List<Pair<Integer, Integer>> ret = new ArrayList<>();
        ret.add(new Pair<>(0, 0));
        ret.add(new Pair<>(v[idx], p[idx]));
        for (int i = 0; i < children.get(idx).size(); i++) {
            int key = v[idx] + v[children.get(idx).get(i)];
            int val = p[idx] + p[children.get(idx).get(i)];
            ret.add(new Pair<>(key, val));
        }
        for (int i = 0; i < children.get(idx).size(); i++) {
            for (int j = i + 1; j < children.get(idx).size(); j++) {
                int key = v[idx] + v[children.get(idx).get(i)] + v[children.get(idx).get(j)];
                int val = p[idx] + p[children.get(idx).get(i)] + p[children.get(idx).get(j)];
                ret.add(new Pair<>(key, val));
            }
        }
        return ret;
    }

    private static int calculate(int[] v, int[] p, int[] q, int n, int m, List<List<Integer>> children) {
        int[] dp = new int[n + 1];
        int[] dp1;
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            if (q[i] == 0) {
                List<Pair<Integer, Integer>> data = cal(i, v, p, children);
                dp1 = new int[n + 1];
                for (int k = 0; k < data.size(); k++) {
                    for (int j = data.get(k).getKey(); j <= n; j += 10) {
                        dp1[j] = Math.max(dp1[j], dp[j - data.get(k).getKey()] + data.get(k).getValue());
                    }
                }
                dp = dp1;
            }
        }
        for (int i = 0; i <= n; i++)
            ans = Math.max(ans, dp[i]);
        return ans;
    }

    static class Pair<T,E>{
        T key;
        E val;
        Pair(T key, E val){
            this.key = key;
            this.val = val;
        }

        public T getKey() {
            return key;
        }

        public E getValue() {
            return val;
        }
    }
}


