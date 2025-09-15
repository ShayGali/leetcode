package algorithms.medium.maximum_average_pass_ratio_1792;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
//        int[][] classes = {{1,2},{3,5},{2,2}};
//        int extraStudents = 2;
        int[][] classes = {{97, 500}, {30, 915}, {400, 856}, {444, 623}, {781, 786}, {3, 713}};
        int extraStudents = 8;
        Solution solution = new Solution();
        double result = solution.maxAverageRatio(classes, extraStudents);
        System.out.println(result);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            double d1 = (double) (o1[0] + 1) / (o1[1] + 1) - (double) o1[0] / o1[1];
            double d2 = (double) (o2[0] + 1) / (o2[1] + 1) - (double) o2[0] / o2[1];
            return Double.compare(d2, d1);
        });

        for (int[] c : classes) {
            pq.offer(c);
        }

        while (extraStudents > 0) {
            int[] c = pq.poll();
            c[0]++;
            c[1]++;
            pq.offer(c);
            extraStudents--;
        }

        double sum = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            sum += (double) c[0] / c[1];
            count++;
        }
        return sum / count;
    }
}
