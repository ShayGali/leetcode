package algorithms.medium.find_the_index_of_the_first_occurrence_in_a_string_28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = i + 1;
                while (j < haystack.length() && j - i < needle.length() && haystack.charAt(j) == needle.charAt(j - i)) {
                    j++;
                }
                if (j - i == needle.length()) return i;
            } else if (needle.length() >= haystack.length() - i) return -1;
        }
        return -1;
    }

    @Test
    void test(){
        Solution s = new Solution();
        assertEquals(0,s.strStr("sadbutsad", "sad"));
        assertEquals(2,s.strStr("aasadbutsad", "sad"));
        assertEquals(1,s.strStr("tsad", "sad"));
        assertEquals(-1,s.strStr("ad", "sad"));
        assertEquals(0,s.strStr("sad", "sad"));
        assertEquals(4,s.strStr("adassad", "sad"));
    }
}
