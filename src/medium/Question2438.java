package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2438 {

    public static void main(String[] args) {
        int[][] qu = {{0, 1}, {2, 2}, {0, 3}};
        System.out.println(Arrays.toString(productQueries(15, qu)));
        int[][] qu1 = {{0, 0}};
        System.out.println(Arrays.toString(productQueries(13, qu1)));
    }

    public static int[] productQueries(int n, int[][] queries) {
        int mod = 1_000_000_007;
        String bns = Integer.toBinaryString(n);
        List<Integer> powers = new ArrayList<>();
        int pointer = 0;
        for (int i = bns.length() - 1; i >= 0; i--) {
            if (bns.charAt(i) == '1') {
                powers.add(1 << pointer);
            }
            pointer++;
        }
        int[] rs = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long prod = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                prod = (prod * powers.get(j)) % mod;
            }
            rs[i] = (int) prod;
        }
        return rs;
    }
}
