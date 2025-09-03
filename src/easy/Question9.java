package easy;

public class Question9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int temp = x;
        int reverse = 0;
        while (temp > 0) {
            reverse = 10 * reverse + temp % 10;
            temp /= 10;
        }
        return reverse == x;
    }
}
