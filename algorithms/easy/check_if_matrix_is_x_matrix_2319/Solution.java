package algorithms.easy.check_if_matrix_is_x_matrix_2319;

class Solution {
    public boolean checkXMatrix(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if((i==j || j==grid[i].length-i-1)){
                    if(grid[i][j]==0)return false;
                }else{
                    if(grid[i][j]!=0)return false;
                }
            }
        }
        return true;
    }
}
