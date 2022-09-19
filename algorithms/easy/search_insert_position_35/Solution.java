package algorithms.easy.search_insert_position_35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0, r = nums.length-1, mid;
        while(l<=r){
            mid = (r+l)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target) l=mid+1;
            else r=mid-1;
        }
        return l;
    }
}
