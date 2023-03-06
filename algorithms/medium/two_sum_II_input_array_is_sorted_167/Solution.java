package algorithms.medium.two_sum_II_input_array_is_sorted_167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) { // כל עוד הם לא התשובה
            if (numbers[l] + numbers[r] > target) r--; // אם הם גדולים אז נקטין את העיניין
            else l++; // נגדיל אותו
        }
        return new int[]{l + 1, r + 1}; // השאלה רוצה מערך שמתחיל ב1
    }
}
