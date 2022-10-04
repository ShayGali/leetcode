package algorithms.easy.valid_palindrome_II_680;

/*
"aba"
"abca"
"abc"
"eeccccbebaeeabebccceea"
"eedede"
"ebcbbececabbacecbbcbe"
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    boolean isPalindrome(String s, int l, int r) {
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    // work on small inputs
    public boolean validPalindrome1(String s) {
        boolean flag;
        int ignoreIndex = -1;
        while (ignoreIndex < s.length()) {
            flag = true;
            int l = 0, r = s.length() - 1;
            while (l < r) {
                if (l == ignoreIndex) l++;
                else if (r == ignoreIndex) r--;
                else {
                    if (s.charAt(l) != s.charAt(r)) {
                        flag = false;
                        break;
                    }
                    l++;
                    r--;
                }
            }
            if (flag) return true;
            ignoreIndex++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("ebcbbececabbacecbbcbe"));
        /*
        ececabbacec
         */
    }
}
