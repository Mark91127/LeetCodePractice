package medium;

import java.util.HashMap;
import java.util.Map;

public class Question2787 {
    public static void main(String[] args) {
        System.out.println(numberOfWays(10, 2)); // 3
    }

    public static int numberOfWays(int n, int x) {
        int mod = 1_000_000_007;
        Map<String, Integer> trace = new HashMap<>();
        return findPath(n, 1, x, trace, mod);
    }

    private static int findPath(int remaining, int current, int x, Map<String, Integer> trace, int mod) {
        if (remaining == 0)
            return 1;
        if (remaining < 0 || Math.pow(current, x) > remaining)
            return 0;
        String key = remaining + "+" + current;
        if (trace.containsKey(key)) return trace.get(key);
        int power = (int) Math.pow(current, x);
        int include = findPath(remaining - power, current + 1, x, trace, mod);
        int skip = findPath(remaining, current + 1, x, trace, mod);
        int total = (include + skip) % mod;
        trace.put(key, total);
        return total;
    }
}
