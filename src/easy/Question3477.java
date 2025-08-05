package easy;

public class Question3477 {
    public static void main(String[] args) {
        int[] fruits = {3, 6, 1};
        int[] baskets = {6, 4, 7};
        System.out.println(numOfUnplacedFruits(fruits, baskets));
    }

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        // Track the number of fruits that cannot be placed in any basket
        int unplaced = fruits.length;
        // Iterate through each fruit in the fruits array
        for (int fruit : fruits) {
            // Check each basket to find one that can hold the current fruit
            for (int j = 0; j < baskets.length; j++) {
                // If the basket's capacity is sufficient, and it hasn't been used
                if (baskets[j] >= fruit) {
                    // Decrease the count of unplaced fruits
                    unplaced--;
                    // Mark the basket as used by setting its capacity to -1
                    baskets[j] = -1;
                    break;
                }
            }
        }
        return unplaced;
    }
}
