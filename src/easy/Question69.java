package easy;

public class Question69 {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if ((int) Math.sqrt(i) != mySqrt(i)) {
                System.out.println(i);
                System.out.println("wrong");
            }
        }
    }

    public static int mySqrt(int x) {
        int low = 0;
        int high = x;
        int mid;
        int probNum = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square == x) {
                return mid;
            } else if (square > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
                probNum = mid;
            }
        }
        return probNum;
    }
}
