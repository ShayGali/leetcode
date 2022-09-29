package algorithms.medium.longest_palindromic_substring_5;

class Solution {
  /*
    // O(n^3)
    // brute force solution with substring function
    // at best 901ms
    public String longestPalindrome(String s) {
        for(int i = s.length(); i >= 0; i--){
            for(int j = 0; j+i<=s.length();j++){
                String sub = s.substring(j,i+j);
                if(isPalindrome(sub))
                  return sub;
            }
        }
        return "";
    }
    
    boolean isPalindrome(String s){
        for(int i = 0; i< s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length() - i -1))return false;
        }
        return true;
    }
    */
  
  
  // O(n^3)
  // brute force solution with toCharArray function. [for avoid substring (O(n))]
  // at best 91ms
  public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        for(int i = arr.length; i >= 0; i--){
            for(int j = 0; j+i<=arr.length;j++){
                if(isPalindrome(arr,j,i+j))
                  return build(arr,j,i+j);
            }
        }
        return "";
    }
    
    boolean isPalindrome(char[] s, int left, int right){
        while(left < right){
            if(s[left++] != s[--right])return false;
        }
        return true;
    }
    String build(char[] s, int left, int right){
        StringBuilder sb = new StringBuilder();
        for(int i = left; i<right;i++){
            sb.append(s[i]);
        }
        return sb.toString();
    }
    
}
