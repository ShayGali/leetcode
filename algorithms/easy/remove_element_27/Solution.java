package algorithms.easy.remove_element_27;

class Solution {

    public int removeElement(int[] nums, int val) {
        int k = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) k++;
            else {
                swap(nums, i, i - k);
                ans++;
            }

        }
        return ans;
    }


    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
