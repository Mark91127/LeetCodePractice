package medium;

import java.util.*;

public class Question3446 {
    public static void main(String[] args) {
        int[][] a = {{1, 7, 3}, {9, 8, 2}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(sortMatrix(a)));
        int[][] b = {{2, -4, 0}, {2, 0, -4}, {-4, 2, 0}};
        System.out.println(Arrays.deepToString(sortMatrix(b)));
        //[[2,-4,0],[2,0,-4],[-4,2,0]]
        int[][] c = {{-1, 2, 1}, {0, 3, -5}, {0, 2, 1}};
        System.out.println(Arrays.deepToString(sortMatrix(c)));
        //[[3,-5,1],[2,1,2],[0,0,-1]]
    }

    public static int[][] sortMatrix(int[][] grid) {
        // column exclude 1st column
        for (int i = 0; i < grid.length; i++) {
            if (i == 0)
                continue;
            List<Integer> diagonal = new ArrayList<>();
            int x = 0;
            int y = i;
            while (y < grid.length) {
                diagonal.add(grid[x][y]);
                x += 1;
                y += 1;
            }
            Collections.sort(diagonal);
            x = 0;
            y = i;
            while (y < grid.length) {
                grid[x][y] = diagonal.removeFirst();
                x += 1;
                y += 1;
            }
        }
        // row
        for (int i = 0; i < grid.length; i++) {
            List<Integer> diagonal = new ArrayList<>();
            int x = i;
            int y = 0;
            while (x < grid.length) {
                diagonal.add(grid[x][y]);
                x += 1;
                y += 1;
            }
            Collections.sort(diagonal);
            Collections.reverse(diagonal);
            x = i;
            y = 0;
            while (x < grid.length) {
                grid[x][y] = diagonal.removeFirst();
                x += 1;
                y += 1;
            }
        }
        return grid;
    }
}
