package Arrays;

/**
 * @author Honghan Zhu
 * @面试题 62
 * @grade easy
 */
public class RamainingNumber {
    public int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i)
            f = (m + f) % i;
        return f;
    }
}
