package algorithms.medium.K_closest_points_to_origin_973;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<>(points.length, (p1, p2) -> Double.compare(distanceFromOrigin(p1), distanceFromOrigin(p2)));

        Collections.addAll(heap, points);

        int[][] res = new int[k][2];
        while (k > 0) {
            res[--k] = heap.poll();
            ;
        }
        return res;
    }

    public double distanceFromOrigin(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }
}
