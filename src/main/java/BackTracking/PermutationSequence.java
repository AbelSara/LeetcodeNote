package BackTracking;

/**
 * @Author Honghan Zhu
 * @leetcode 60
 * @grade medium
 */
public class PermutationSequence {
    int idx = 0;
    String res = "";

    public String getPermutation(int n, int k) {
        backTrack(n, k, new boolean[n + 1], new StringBuilder());
        return res;
    }

    private void backTrack(int n, int k, boolean[] tags, StringBuilder builder) {
        if (!res.isEmpty())
            return;
        if (builder.length() == n) {
            idx++;
            if (idx == k)
                res = builder.toString();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!tags[i]) {
                tags[i] = true;
                builder.append(i);
                backTrack(n, k, tags, builder);
                tags[i] = false;
                builder.deleteCharAt(builder.length() - 1);
                if (!res.isEmpty())
                    return;
            }
        }
    }
}

