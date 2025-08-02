package easy;

import java.util.ArrayList;
import java.util.List;

public class Question2210 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 1, 3, 5, 2, 6, 4, 7, 4};
        int i = countHillValley(arr);
        System.out.println(i);
    }

    public static int countHillValley(int[] nums) {
        // Filter out consecutive duplicates to simplify hill/valley detection
        List<Integer> filtered = new ArrayList<>();
        filtered.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                filtered.add(nums[i]);
        }
        // Count hills and valleys using the filtered list
        int sum = 0;
        for (int i = 1; i < filtered.size() - 1; i++) {
            int front = filtered.get(i - 1);
            int current = filtered.get(i);
            int next = filtered.get(i + 1);
            // Hill: curr > both neighbors, Valley: curr < both neighbors
            sum += ((front > current && next > current) || (front < current && next < current)) ? 1 : 0;
        }
        return sum;
    }
}
