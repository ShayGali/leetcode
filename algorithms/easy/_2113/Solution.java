package algorithms.easy._2113;


class Solution {
    public boolean checkValid(int[][] m) {
        boolean[] b1;
        boolean[] b2;

        for(int i=0;i<m.length;i++){ 
            b1 = new boolean[m.length];
            b2 = new boolean[m.length];
            for(int j=0;j<m.length;j++){
                if(b1[m[i][j]-1] || b2[m[j][i]-1])return false;
                b1[m[i][j]-1] = true;
                b2[m[j][i]-1] = true;
            }
        }
        return true;
    }
}
