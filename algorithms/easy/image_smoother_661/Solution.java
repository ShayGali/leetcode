package algorithms.easy.image_smoother_661;


class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        for(int i=0;i<img.length;i++){
            for(int j=0;j<img[i].length;j++){
                res[i][j] = help(img,i,j);
            }
        }
        return res;
    }
    
    int help(int[][] img, int i, int j){
        int sum=img[i][j],counter=1;
        
        // upper line
        if(i-1 >= 0){
            counter++;
            sum+=img[i-1][j];
            if(j-1>=0){
                counter++;
                sum+=img[i-1][j-1];
            }
            if(j+1 < img[0].length){
                counter++;
                sum+=img[i-1][j+1];
            }
        }
        
        //same line
        if(j-1>=0){
                counter++;
                sum+=img[i][j-1];
        }
        
        if(j+1 < img[0].length){
                counter++;
                sum+=img[i][j+1];
        }
        
        // lower line
        if(i+1 < img.length){
            counter++;
            sum+=img[i+1][j];
            
            if(j-1>=0){
                counter++;
                sum+=img[i+1][j-1];
            }
            if(j+1 < img[0].length){
                counter++;
                sum+=img[i+1][j+1];
            }
        }
        
        return sum/counter;
    }
}
