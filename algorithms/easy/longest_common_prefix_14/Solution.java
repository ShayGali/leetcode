package algorithms.easy.longest_common_prefix_14;

public class Solution {
    public String longestCommonPrefix(String[] arr) {
            if (arr.length == 0) return "";
            String prefix = arr[0];
            for (int i = 1; i < arr.length; i++) {
                while (arr[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
            }
            return prefix;
    }
}
