package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question238 {
    public static void main(String[] args) {
        int[] arr = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int[] nums) {
        // To store the indices of zeros in the array
        List<Integer> zeroIndex = new ArrayList<>();
        // To keep the product of all non-zero elements
        int product = 1;
        // First pass: compute the product of all non-zero numbers,
        // and track where the zeros are
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex.add(i);
                // If more than one zero, all elements in result will be zero
                if (zeroIndex.size() > 1) {
                    break;
                }
                continue;
            }
            product *= nums[i];
        }
        // If more than one zero, all elements in result will be zero
        if (zeroIndex.size() > 1) {
            Arrays.fill(nums, 0);
        }
        // Case 2: Exactly one zero → Only the position of the zero gets the product
        else if (zeroIndex.size() == 1) {
            Arrays.fill(nums, 0);
            nums[zeroIndex.get(0)] = product;
        }
        // Case 3: No zero → Each element is total product divided by the current number
        else {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = product / nums[i];
            }
        }
        return nums;
    }
}
