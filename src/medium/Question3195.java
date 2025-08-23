package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question3195 {
    public static void main(String[] args) {
        int[][] a = {{0, 1, 0}, {1, 0, 1}};
        System.out.println(minimumArea(a));
    }

    public static int minimumArea(int[][] grid) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        Collections.sort(x);
        Collections.sort(y);
        int side = x.getLast() - x.getFirst() + 1;
        int side2 = y.getLast() - y.getFirst() + 1;
        return side * side2;
    }
}
