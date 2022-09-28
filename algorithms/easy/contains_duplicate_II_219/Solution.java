package algorithms.easy.contains_duplicate_II_219;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer n = m.getOrDefault(nums[i], null);
            if (n != null && Math.abs(n - i) <= k) {
                return true;
            }
            m.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) throws ParseException {
        new Solution().containsNearbyDuplicate(new int[]{1,0,1,1}, 1);
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = isoFormat.parse("2010-05-23T09:01:02");
        System.out.println(date);
    }
}
