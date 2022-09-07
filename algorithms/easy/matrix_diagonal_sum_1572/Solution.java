package algorithms.easy.matrix_diagonal_sum_1572;

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for(int i=0;i<mat.length;i++){
            sum+=mat[i][i];
            sum+=mat[i][mat.length-i-1];
        }
        
        if(mat.length%2==1)
            sum-=mat[mat.length/2][mat.length/2];
      
        return sum;                                   
    }
}
