package algorithms.easy.reverse_words_in_a_string_III_557;

class Solution {
   
   // with split function
    public String reverseWords1(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.length-1;i++){
            sb.append(revers(strs[i])).append(" ");
        }
        sb.append(revers(strs[strs.length-1]));
        return sb.toString();
    }
    StringBuilder revers(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1; i>=0;i--){
            sb.append(str.charAt(i));
        }
        return sb;
    }

    // reach to " " and go back 
    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0, temp;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)==' '){
                temp = i-1;
                while(temp >= start){
                    sb.append(s.charAt(temp));
                    temp--;
                }
                start = i+1;
                sb.append(' ');
            }else if(i+1 == s.length()){
                temp = i;
                while(temp >= start){
                    sb.append(s.charAt(temp));
                    temp--;
                }
                start = i+1;
            }
        }
        return sb.toString();
    }

    // add to start of word
     public String reverseWords3(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;

        for(int i=0; i<s.length();i++){
            if(s.charAt(i)==' '){
                 start = i+1;
                 sb.append(' ');
            }else{
                sb.insert(start,s.charAt(i));
            }
        }
        return sb.toString();
     }

    // temp string builder
     public String reverseWords4(String s) {
        StringBuilder sb = new StringBuilder(), temp = new StringBuilder();
        

        for(int i=0; i<s.length();i++){
            if(s.charAt(i)==' '){
                 sb.append(temp).append(' ');
                 temp.setLength(0);
            }else{
                temp.insert(0,s.charAt(i));
            }
        }
        sb.append(temp);
        return sb.toString();
    }

    //with charArray
    public String reverseWords5(String s) {
        char[] arr = s.toCharArray();
        int start=0;
        
        for(int i =0; i<arr.length; i++){
            if(arr[i]==' '){
                revers(arr,start, i-1);
                start = i+1;
            }
        }
        revers(arr,start, arr.length-1);
        return new String(arr);
    }
    
    void revers(char[] arr, int start, int end){
        char temp;
        while(start < end){
            temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
    
}