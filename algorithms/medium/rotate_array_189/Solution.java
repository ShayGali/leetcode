package algorithms.medium.rotate_array_189;

public class Solution {
    /*
    הפתרון הראשון - איטי ולא יעבוד על מספרים גדולים
    הפתרון השני - משתמש במערך עזר
    הפתרון השלישי - הכי יעיל
     */


    class Solution1 { // לא עובד למספרים גדולים
        public void rotate(int[] nums, int k) {
            for (int i = 0; i < k; i++) {
                int l = nums[nums.length - 1];
                for (int j = nums.length - 1; j > 0; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[0] = l;
            }
        }
    }

    class Solution2 {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            int[] res = new int[nums.length];
            for (int i = nums.length - k, j = 0; i < nums.length; i++, j++) {
                res[j] = nums[i];
            }
            for (int i = 0, j = k; i < nums.length - k; i++, j++) {
                res[j] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = res[i];
            }
        }
    }

    class Solution3 {
        /*
        הופכים את כל המערך
        הופכים מההתחלה עד לk לא כולל
        הופכים מ k עד הסוף

        לדוגמא:
        1,2,3,4,5  k = 2
        הפיכה ראשונה
        5,4,3,2,1
        שנייה
        4,5,3,2,1
        שלישית
        4,5,1,2,3
         */
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            reveres(nums,0, nums.length-1);
            reveres(nums,0, k-1);
            reveres(nums,k, nums.length-1);
        }

        void reveres(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }

}
