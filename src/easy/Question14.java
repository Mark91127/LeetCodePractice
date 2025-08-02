package easy;

public class Question14 {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr));
        arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates1(arr));
    }

    /**
     * Version 1: Custom two-pointer logic to remove duplicates from sorted array.
     * Returns the number of unique elements.
     */
    public static int removeDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            // currIndex scans ahead to find the next unique value
            int currIndex = i;
            // nextIndex indicates the position to store the next unique value
            int nextIndex = i + 1;
            while (true) {
                currIndex++;
                // end of array: return number of unique values
                if (currIndex == nums.length) {
                    return nextIndex;
                }
                // found next unique value in sorted array
                if (nums[currIndex] != curr && nums[currIndex] > curr) {
                    nums[nextIndex] = nums[currIndex];
                    break;
                }
            }
        }
        return 0; // should not reach here
    }

    /**
     * Version 2: My preferred (official-style) solution. (much faster)
     * Removes duplicates in-place from a sorted array.
     * Returns the number of unique elements.
     */
    public static int removeDuplicates1(int[] nums) {
        // i tracks the position of the last unique element
        int i = 0;
        // j scans through the array
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // Store the next unique value
            }
        }
        return i + 1;
    }
}
