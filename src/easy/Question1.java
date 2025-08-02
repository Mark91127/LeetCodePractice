package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question1 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(a, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        // nums[index] : index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another))
                return new int[]{map.get(another), i};
            map.put(nums[i], i);
        }
        return null;
    }
}
