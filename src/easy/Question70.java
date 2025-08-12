package easy;

public class Question70 {
    public static int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
        int[] fn = new int[n + 1];
        fn[0] = 1;
        fn[1] = 1;
        for (int i = 2; i <= n; i++) {
            fn[i] = fn[i - 1] + fn[i - 2];
        }
        return fn[n];
    }
}
