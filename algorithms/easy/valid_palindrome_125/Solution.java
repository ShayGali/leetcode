package algorithms.easy.valid_palindrome_125;

public class Solution {
    // Two Pointer with Character class method
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char lCh, rCh;
        while (l < r) {
            lCh = s.charAt(l);
            if (!Character.isLetterOrDigit(lCh)) {
                l++;
                continue;
            }
            rCh = s.charAt(r);
            if (!Character.isLetterOrDigit(rCh)) {
                r--;
                continue;
            }
            if ('A' <= lCh && lCh <= 'Z') lCh += 32;
            if ('A' <= rCh && rCh <= 'Z') rCh += 32;
            if (lCh != rCh) return false;
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isAlphanumeric1(ch)) {
                sb.append(ch);
            } else if ('A' <= ch && ch <= 'Z') {
                ch += 32;
                sb.append(ch);
            }
        }

        for (int i = 0; i < sb.length() / 2; i++)
            if (sb.charAt(i) != sb.charAt(sb.length() - i - 1))
                return false;

        return true;
    }

    boolean isAlphanumeric1(char ch) {
        return '0' <= ch && ch <= '9' || 'a' <= ch && ch <= 'z';
    }

    public boolean isPalindrome2(String s) {
        int l = 0, r = s.length() - 1;
        char lCh, rCh;
        while (l < r) {
            lCh = s.charAt(l);
            if (!isAlphanumeric2(lCh)) {
                l++;
                continue;
            }
            rCh = s.charAt(r);
            if (!isAlphanumeric2(rCh)) {
                r--;
                continue;
            }
            if ('A' <= lCh && lCh <= 'Z') lCh += 32;
            if ('A' <= rCh && rCh <= 'Z') rCh += 32;
            if (lCh != rCh) return false;
            l++;
            r--;
        }


        return true;
    }

    boolean isAlphanumeric2(char ch) {
        return '0' <= ch && ch <= '9' || 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z';
    }


}
