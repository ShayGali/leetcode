package algorithms.easy.relative_ranks_506;

import java.util.PriorityQueue;

public class Solution {
    public String[] findRelativeRanks(int[] score) {
        // הרעיון כאן זה לשמור את האינדסקים בתוך ערמה, שהסדר שלהם יהיה לפי הציון שלהם
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> score[b] - score[a]);
        String[] res = new String[score.length];

        for (int i = 0; i < score.length; i++) heap.add(i); // מוסיף את האינדקס לערמה

        for (int i = 1; !heap.isEmpty(); i++) {
            if (i == 1) {
                res[heap.poll()] = "Gold Medal";
            } else if (i == 2) {
                res[heap.poll()] = "Silver Medal";
            } else if (i == 3) {
                res[heap.poll()] = "Bronze Medal";
            } else {
                res[heap.poll()] = String.valueOf(i);
            }

        }

        return res;
    }
}
