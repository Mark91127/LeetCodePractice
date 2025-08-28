package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question73 {
    public static void main(String[] args) {
        int[][] a = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes3(a);
        System.out.println(Arrays.deepToString(a));
        int[][] b = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes3(b);
        System.out.println(Arrays.deepToString(b));
        //[[1,0,1],[0,0,0],[1,0,1]]
        int[][] c = {{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        setZeroes3(c);
        System.out.println(Arrays.deepToString(c));
        int[][] d = {{0, 1}};
        setZeroes3(d);
        System.out.println(Arrays.deepToString(d));
        //[[0,0]]
        int[][] e = {{-4, -2147483648, 6, -7, 0}, {-8, 6, -8, -6, 0}, {2147483647, 2, -9, -6, -10}};
        setZeroes3(e);
        System.out.println(Arrays.deepToString(e));
        //[[0,0,0,0,0],[0,0,0,0,0],[2147483647,2,-9,-6,0]]
    }

    // O(m + n) space (not a good answer)
    public static void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }
        for (Integer i : row) {
            Arrays.fill(matrix[i], 0);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (Integer integer : column) {
                matrix[i][integer] = 0;
            }
        }
    }

    // O(n) space n = columns (still not good enough)
    public static void setZeroes2(int[][] matrix) {
        boolean setRowToZero = false;
        Set<Integer> column = new HashSet<>();
        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 0) {
                    setRowToZero = true;
                    column.add(j);
                }
            }
            if (setRowToZero) {
                Arrays.fill(ints, 0);
                setRowToZero = false;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (Integer integer : column) {
                matrix[i][integer] = 0;
            }
        }
    }

    // in place O(1) space
    public static void setZeroes3(int[][] matrix) {
        boolean setFirstRowToZero = matrix[0][0] == 0;
        boolean setFirstColumnToZero = matrix[0][0] == 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) {
                        setFirstRowToZero = true;
                    }
                    if (j == 0) {
                        setFirstColumnToZero = true;
                    }
                }
            }
        }
        for (int i = matrix[0].length - 1; i > 0; i--) {
            if (matrix[0][i] == 0)
                fillColumnWithZero(matrix, i);
        }
        for (int i = matrix.length - 1; i > 0; i--) {
            if (matrix[i][0] == 0)
                Arrays.fill(matrix[i], 0);
        }
        if (setFirstRowToZero) {
            Arrays.fill(matrix[0], 0);
        }
        if (setFirstColumnToZero) {
            fillColumnWithZero(matrix, 0);
        }
    }

    private static void fillColumnWithZero(int[][] matrix, int i) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][i] = 0;
        }
    }
}
