package easy;

import java.util.Arrays;

public class Question27 {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        System.out.println(removeElement(new int[]{2, 3, 4, 2, 3, 2, 2, 2, 2, 2, 2, 2}, 2));
        System.out.println(removeElement(new int[]{0, 2, 3, 4, 5, 11, 2, 4, 3, 2, 1, 5, 6, 8, 9, 2, 1, 2, 3, 4, 1}, 3));
        System.out.println(removeElement(new int[]{}, 3));
        System.out.println(removeElement(new int[]{3, 3, 3}, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int place = nums.length - 1;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = place; j >= i; j--) {
                    place--;
                    if (nums[j] != val) {
                        nums[i] = nums[j];
                        break;
                    }
                }
            } else {
                k++;
            }
        }
        return k;
    }
}
