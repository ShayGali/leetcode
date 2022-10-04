package algorithms.medium.longest_substring_without_repeating_characters_3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = i;
            Set<Character> set = new HashSet<>();
            while (temp < s.length() && !set.contains(s.charAt(temp))) {
                set.add(s.charAt(temp));
                temp++;
            }
            if (set.size() > max) max = set.size();
        }
        return max;
    }
    */
    public int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);
            Integer last = map.get(current);
            if(last!=null && left <= last){
                left = last + 1;
            }
            map.put(current, i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
    }
}
