package algorithms.easy.maximum_average_subarray_I_643;


class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        for(int i =0; i<k;i++){
            maxSum+=nums[i];
        }
        int currentSum = maxSum;
        for(int i = k ;i<nums.length;i++){
            currentSum = currentSum-nums[i-k]+nums[i];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return (double)maxSum/k;
    }
}
