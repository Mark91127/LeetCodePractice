package medium;

import java.util.Arrays;

public class Question189 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 77, 66, 33, 55, 44};
        rotate(arr, 3);
        int[] arr1 = {-1, -100, 3, 99};
        rotate(arr1, 3);
        int[] arr2 = {1};
        rotate(arr2, 1);
        int[] arr3 = {1, 2};
        rotate(arr3, 7);
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 44, -10, 45};
        rotate2(arr4, 2);
        int[] arr5 = {-1, -100, 3, 99};
        rotate2(arr5, 2);
        int[] arr6 = {1};
        rotate2(arr6, 1);
        int[] arr7 = {1, 2};
        rotate2(arr7, 7);
    }

    // version 1
    public static void rotate(int[] nums, int k) {
        // k may exceed array length
        k = k % nums.length;
        // no rotation needed if array has fewer than 2 elements or k is equals to 0 or array's length
        if (nums.length < 2 || k == 0)
            return;
        // create a temporary array to store rotated elements
        int[] arr = new int[nums.length];
        for (int num : nums) {
            arr[k] = num;
            k++;
            if (k == nums.length) {
                k = 0;
            }
        }
        // copy the rotated array back to the original one
        System.arraycopy(arr, 0, nums, 0, arr.length);
        System.out.println(Arrays.toString(nums));
    }

    // version 2 ( O(1) space)
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        if (nums.length < 2 || k == 0)
            return;
        // reverse the whole array
        reverseArray(nums, 0, nums.length - 1);
        // reverse < k elements
        reverseArray(nums, 0, k - 1);
        // reverse the last (n - k) elements
        reverseArray(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void reverseArray(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
