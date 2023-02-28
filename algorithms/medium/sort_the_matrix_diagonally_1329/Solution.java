package algorithms.medium.sort_the_matrix_diagonally_1329;

public class Solution {


    static void print(int[][] mat) {
        for (int k = 0; k < mat.length; k++) {
            for (int j = 0; j <= k; j++) {
                int i = k - j;
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        };

    }
}
