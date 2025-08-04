package easy;

public class Question724 {
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(arr));
        System.out.println(pivotIndex2(arr));
        int[] arr1 = {2, 1, -1};
        System.out.println(pivotIndex(arr1));
        System.out.println(pivotIndex2(arr1));
    }

    // Finds the pivot index where the sum of elements to the left equals the sum to the right.
    // If no such index exists, returns -1. Uses prefix sums.
    public static int pivotIndex(int[] nums) {
        // Initialize prefix sum array to store cumulative sums
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = 0; i < prefixSum.length; i++) {
            // For index 0, left sum is 0, right sum is total sum minus nums[0]
            if (i == 0) {
                if (prefixSum[prefixSum.length - 1] - prefixSum[0] == 0) {
                    return 0;
                }
                continue;
            }
            // Check if left sum (prefixSum[i-1]) equals right sum (total sum - nums[i])
            if (prefixSum[i - 1] == prefixSum[prefixSum.length - 1] - prefixSum[i]) {
                return i;
            }
            // For last index, right sum is 0, check if left sum equals 0
            if (i == prefixSum.length - 1) {
                if (prefixSum[i - 1] == 0) {
                    return i;
                }
            }
        }
        // No pivot index found
        return -1;
    }

    // Uses O(1) space by computing total sum first.
    public static int pivotIndex2(int[] nums) {
        // Calculate total sum of all elements
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // Track sum of elements to the left
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // Check if left sum equals right sum (totalSum - nums[i] - leftSum)
            if (leftSum == totalSum - nums[i] - leftSum) {
                return i;
            }
            // Add current element to left sum for next iteration
            leftSum += nums[i];
        }
        return -1;
    }
}
