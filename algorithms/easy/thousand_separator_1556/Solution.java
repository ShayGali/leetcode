package algorithms.easy.thousand_separator_1556;

class Solution {
    public String thousandSeparator(int n) {
        if(n==0)return "0";
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        while(n!=0){
            sb.insert(0,n%10);
            n /= 10;
            counter++;
            if(counter%3 == 0 && n!=0){
                sb.insert(0,'.');
            }
        }
        return sb.toString();
    }
}
