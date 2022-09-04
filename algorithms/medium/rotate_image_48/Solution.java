package algorithms.medium.rotate_image_48;

class Solution {
    public void rotate(int[][] m) { // מסובבים הפוך 
        int l =0, r=m.length-1;
        while(l<r){
            for(int i =0; i<r-l;i++){
                int t=l, b=r;
                
                int tl = m[t][l+i]; //save the top left
                
                m[t][l+i]=m[b-i][l]; // move bottom left to top left
                m[b-i][l]=m[b][r-i]; // move bottom rigth to botton left
                m[b][r-i]=m[t+i][r]; // mvoe top right to botton rigth
                m[t+i][r]=tl;        // move top left to top right
            }
            l++;
            r--;
        }
    }
}
