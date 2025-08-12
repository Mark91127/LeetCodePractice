package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question869 {
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(640));
        System.out.println(reorderedPowerOf2_2(46));
    }

    // 1
    public static boolean reorderedPowerOf2(int n) {
        if (n < 10) {
            return (n & (n - 1)) == 0;
        }
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        Set<String> set = new HashSet<>();
        permute(chars, set, 0);
        for (String string : set) {
            int rs = Integer.parseInt(string);
            if ((rs & rs - 1) == 0) {
                return true;
            }
        }
        return false;
    }

    private static void permute(char[] chars, Set<String> set, int start) {
        if (start == chars.length) {
            set.add(new String(chars));
            return;
        }
        for (int i = start; i < chars.length; i++) {
            if (start == 0 && chars[i] == '0') {
                continue;
            }
            swap(chars, start, i);
            permute(chars, set, start + 1);
            swap(chars, start, i);
        }
    }

    private static void swap(char[] chars, int first, int second) {
        char temp = chars[first];
        chars[first] = chars[second];
        chars[second] = temp;
    }


    // 2
    private static boolean reorderedPowerOf2_2(int n) {
        String target = sorted(n);
        for (int i = 0; i < 31; i++) {
            int powerOf2 = 1 << i;
            String sorted = sorted(powerOf2);
            if (sorted.equals(target))
                return true;
        }
        return false;
    }

    private static String sorted(int n) {
        String s = String.valueOf(n);
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
