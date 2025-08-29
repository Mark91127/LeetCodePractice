package medium;

public class Question3021 {
    public static void main(String[] args) {
        System.out.println(flowerGame(3, 2));
        System.out.println(flowerGame(1, 1));
        System.out.println(flowerGame(10, 5));
        System.out.println(flowerGame(100000, 10000));
    }

    // 1 < n,m
    public static long flowerGame(int n, int m) {
        long nEven = n / 2;
        long nOdd = n - nEven;
        long mEven = m / 2;
        long mOdd = m - mEven;
        return nOdd * mEven + nEven * mOdd;
    }
}
