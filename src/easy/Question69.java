package easy;

public class Question69 {
    public static void main(String[] args) {
        // Simple test to compare mySqrt with Math.sqrt
        for (int i = 0; i < 1000; i++) {
            if ((int) Math.sqrt(i) != mySqrt(i)) {
                System.out.println(i);
                System.out.println("wrong");
            }
        }
    }

    public static int mySqrt(int x) {
        // Binary search to find the integer square root of x
        int low = 0;
        int high = x;
        int mid;
        int result = 0; // stores the best integer approximation of sqrt(x)
        while (low <= high) {
            mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square == x) {
                return mid;
            } else if (square > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
                result = mid; // Store the best candidate so far
            }
        }
        return result;
    }
}
