package algorithms.easy.remove_duplicates_from_sorted_array_26;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int last = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[last]) {
                last++;
                nums[last] = nums[i];
            }
        }
        return last + 1;
    }
    /*
      האלמנט הראשון הוא בוודאות ייחודי
      אני מתחיל לרוץ על המערך, ברגע שיש לי אלמנט חדש
      אני מקדם את המצביע
      ומעביר את האלמנט החדש לאן שצריך
      וככה אני שם את כל האלמנטים המיוחדים בהתחלה
      ובסוף אני נשאר עם האינדקס האחרון שאליו הכנסתי אז אני מחזיר ועוד 1 כי זאת כמות  האלמנטים
       */

}
