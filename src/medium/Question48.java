package medium;

import java.util.Arrays;

public class Question48 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void rotate(int[][] matrix) {
        // Transpose the matrix (swap elements across the main diagonal to convert rows to columns)
        for (int i = 0; i < matrix.length; i++) {
            // Start from i + 1 to avoid swapping elements twice and to skip diagonal elements
            for (int j = i + 1; j < matrix.length; j++) {
                // Store the current element in a temporary variable
                int temp = matrix[i][j];
                // Swap element at [i][j] with element at [j][i].  e.g. (0,1) <-> (1,0)
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row (swap leftmost elements with rightmost elements).
        for (int i = 0; i < matrix.length; i++) {
            // Iterate up to half the row length to swap elements from both ends
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                // Swap element at index j with element at the symmetric index from the end.
                // e.g. (0,0) <-> (0,2)
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
