package easy;

import java.util.Arrays;

public class Question66 {
    public static void main(String[] args) {
        int[] arr = {9, 9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
        // right to left
        for (int i = digits.length - 1; i >= 0; i--) {
            // if the current digit is less than 9, increment it and return the array
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            // If the digit is 9, set it to 0
            digits[i] = 0;
        }
        // if exit the loop, all digits were 9 ( [9, 9] → [0, 0] )
        // just create a new array with one extra digit and set the 1st to 1 ( [1, 0, 0] )
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
