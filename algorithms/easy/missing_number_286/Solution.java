package algorithms.easy.missing_number_286;

class Solution {

    // O(1) space
    public int missingNumber(int[] nums) {
        int sum = ((2+(nums.length-1))*nums.length)/2;
        
        for(int i=0;i<nums.length;i++)
            sum-=nums[i];
        
        return sum;
    }
    
    /* O(n} space
    public int missingNumber(int[] nums) {
        boolean[] b = new boolean[nums.length+1];
        for(int i =0; i<nums.length;i++){
            b[nums[i]] = true;
        }
        for(int i =0; i<b.length;i++){
            if(!b[i])return i;
        }
        
        return -1;
    }
    */
}
