package algorithms.medium.search_a_2D_matrix_74;

class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int lRow=0, lCol=0;
        int rRow=mat.length-1, rCol=mat[0].length-1;
        int mid, midRow, midCol;
      
        while(lRow<rRow || (lRow==rRow && lCol<=rCol)){
          
            mid = ((lRow * mat[0].length + lCol) + (rRow * mat[0].length + rCol))/2;
            midRow = mid/mat[0].length;
            midCol = mid%mat[0].length;
            
            if(mat[midRow][midCol] == target) return true;
            
            if(mat[midRow][midCol] < target){
                if(midCol+1 == mat[0].length){
                    lRow = midRow+1;
                    lCol = 0;
                }else{
                    lRow = midRow;
                    lCol = midCol+1;
                }
            }else{
                if(midCol-1 == -1){
                    rRow = midRow-1;
                    rCol = mat[0].length-1;
                }else{
                    rRow = midRow;
                    rCol = midCol-1;
                }
            }
        }
        return false;
    }
}
