package easy;

public class Question485 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        // count: current number of consecutive 1s
        int count = 0;
        // bestCount: maximum number of consecutive 1s found so far
        int bestCount = 0;
        for (int num : nums) {
            if (num != 1) {
                // When a 0 is encountered, update bestCount if needed
                if (count > bestCount)
                    bestCount = count;
                // Reset count for the next sequence of 1s
                count = 0;
                continue;
            }
            // Increment count for a consecutive 1
            count++;
        }
        // After the loop, return the maximum of bestCount and the last count
        return Math.max(bestCount, count);
    }
}
