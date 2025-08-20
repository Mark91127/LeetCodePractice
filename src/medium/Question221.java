package medium;

public class Question221 {
    public static void main(String[] args) {
        char[][] a = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1',
                '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(a));
        char[][] b = {{'1'}};
        System.out.println(maximalSquare(b));
        char[][] c = {{'1', '0'}, {'0', '1'}};
        System.out.println(maximalSquare(c));
        char[][] d = {{'0', '0'}, {'0', '0'}};
        System.out.println(maximalSquare(d));
        char[][] e = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'0', '0', '1', '1', '1'}
        };
        System.out.println(maximalSquare(e));
        char[][] f = {
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(maximalSquare(f));
        char[][] g = {
                {'0', '0', '0', '1', '0', '1', '1', '1'},
                {'0', '1', '1', '0', '0', '1', '0', '1'},
                {'1', '0', '1', '1', '1', '1', '0', '1'},
                {'0', '0', '0', '1', '0', '0', '0', '0'},
                {'0', '0', '1', '0', '0', '0', '1', '0'},
                {'1', '1', '1', '0', '0', '1', '1', '1'},
                {'1', '0', '0', '1', '1', '0', '0', '1'},
                {'0', '1', '0', '0', '1', '1', '0', '0'},
                {'1', '0', '0', '1', '0', '0', '0', '0'}
        };
        System.out.println(maximalSquare(g));
    }

    public static int maximalSquare(char[][] matrix) {
        int biggestSideSoFar = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    }
                    biggestSideSoFar = Math.max(biggestSideSoFar, dp[i][j]);
                }
            }
        }
        return biggestSideSoFar * biggestSideSoFar;
    }
}
