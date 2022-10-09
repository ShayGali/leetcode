package algorithms.hard.first_missing_positive_41;

public class Solution {
    /*
    במקרה הכי גרוע המספר הכי קטן שיכול להיות יהיה האורך של המערך ועוד אחד.
    אני מביא כל מספר לאינקס שלו פחות אחד, ואז זה כמו מיון
    ואז אני בודק אם באמת הבאתי לכ מספר לאינדקס שלו, אם חסר שם זה אומר שהוא לא הופיע במערך
    (לא מעניין אותי מספר כפולים ומספרים שגדולים מהאורך של המערך ומספר לא-חיוביים)
     */
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    /*
    [1,2,0]
    [3,4,-1,1]
    [7,8,9,11,12]
    [1]
    [2,1]
    [-1, 4, 2, 1, 9, 10]
     */
    public static void main(String[] args) {
        new Solution().firstMissingPositive(new int[]{-1, 4, 2, 1, 9, 10});
    }

}
