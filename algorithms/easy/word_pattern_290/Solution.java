package algorithms.easy.word_pattern_290;

import java.util.HashMap;
import java.util.Map;

/*
"abba"
"dog dog dog dog"
-----------------
"jquery"
"jquery"
-----------------
"aaa"
"aa aa aa aa"
-----------------
"ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd"
"s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"
 */
public class Solution {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Object, Object> map = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            if (map.put(words[i], i) != map.put(pattern.charAt(i), i))
                return false;
        }
        return true;
    }

    public boolean wordPattern1(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Character, String> patternToWord = new HashMap<>();
        Map<String, Character> wordToPattern = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (patternToWord.containsKey(pattern.charAt(i))) {
                if (!patternToWord.get(pattern.charAt(i)).equals(words[i])) return false;
            } else if (wordToPattern.containsKey(words[i])) {
                if (!wordToPattern.get(words[i]).equals(pattern.charAt(i))) return false;
            } else {
                patternToWord.put(pattern.charAt(i), words[i]);
                wordToPattern.put(words[i], pattern.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd",
                "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t");
    }
}

