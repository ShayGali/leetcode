
package algorithms.easy.find_n_unique_integers_sum_up_to_zero_1304;

class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        for(int i = 0; i<n/2;i++){
            res[i] = i+1;
            res[n-i-1] = -(i+1);
        }
        return res;
    }
}
