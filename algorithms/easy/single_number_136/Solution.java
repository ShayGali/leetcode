package algorithms.easy.single_number_136;

public class Solution {
    //הטריק כאן זה לזכור שxor היא פעולה קוממטטיבית, וש x^x = 0 (פעולת xor)
    // ואז אם נפעיל אותה על כל המערך עם אותה תוצאה נקבל רק את המספר שמופיע פעם אחת. (כי כל השאר יתאפסו)
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) res ^= n;
        return res;
    }
}
