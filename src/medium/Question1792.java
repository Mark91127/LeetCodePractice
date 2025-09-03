package medium;

import java.util.*;

public class Question1792 {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 5}, {2, 2}};
        System.out.println(maxAverageRatio(a, 2));
        int[][] b = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        System.out.println(maxAverageRatio(b, 4));
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        // sorted from high margin benefit
        Queue<double[]> queue = new PriorityQueue<>(
                Comparator.comparingDouble((double[] a) -> a[0]).reversed());
        // initialize
        for (int[] aClass : classes) {
            double pass = aClass[0];
            double total = aClass[1];
            queue.add(produceMargin(pass, total));
        }
        // keep calculating until extraStudents = 0
        while (extraStudents > 0) {
            double[] poll = queue.remove();
            double pass = poll[1] + 1;
            double total = poll[2] + 1;
            queue.add(produceMargin(pass, total));
            extraStudents--;
        }
        double sum = 0;
        for (double[] doubles : queue) {
            sum += doubles[1] / doubles[2];
        }
        return sum / classes.length;
    }

    public static double[] produceMargin(double pass, double total) {
        return new double[]{((pass + 1) / (total + 1)) - (pass / total), pass, total};
    }
}
