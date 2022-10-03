package algorithms.easy.length_of_last_word_58;

class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() - 1;
        while (s.charAt(i) == ' ') i--;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            count++;
        }
        return count;
    }
}
