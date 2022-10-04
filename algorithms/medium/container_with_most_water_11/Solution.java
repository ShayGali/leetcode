package algorithms.medium.container_with_most_water_11;

class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, max = 0;
        while(l < r){
          
          /* double check
            int amount = Math.min(height[l],height[r]) * (r-l); // clac the amount of water
            
            if(max < amount) // update the max
                max = amount;
            
            if(height[l] < height[r]) // keep the tall line
                l++;
            else
                r--;
          */
            if(height[l] < height[r]){ 
                if(max < height[l] * (r-l)) max = height[l] * (r-l);
                l++;
            }
            else{
               if(max < height[r] * (r-l)) max = height[r] * (r-l);
                r--;
            }
        }
        
        return max;
    }
}
