package algorithms.easy.palindrome_linked_list_234;

import algorithms.classes.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true; // אם יש אלמנט אחד אז הוא פלינדרום

        ListNode slow = head, fast = head; // כדי להגיע למרכז הרשימה
        ListNode prev = null, next; // כדי להפוך אותה תוך כדי
        // רץ על הרשימה עד שמגיע לחצי והופך אותה תוך כדי
        while (fast != null && fast.next != null) {
            // ריצה לחצי
            fast = fast.next.next;
            next = slow.next; // כדי לשמור את ההבא
            // הפיכה
            slow.next = prev; // הפיכה
            prev = slow; // הוא הקודם עכשיו

            slow = next; // קידום לריצה הבאה
        }

        // אם יש לי מספר אי זוגי של אלמנטים אז fast לא יהיה null אז אפשר לקדם
        /*
        לדוגמא
        1,1,2,1,1
        יישאר בסוף
        slow - [2, 1, 1]
        prev - [1, 1]
        אז נקדם את slow מהאמצע
         */
        if (fast != null) slow = slow.next;

        // לבדוק שגם הרשימה ההפוכה וגם המקורית הם שוות
        while (slow != null && prev != null) {
            if (slow.val != prev.val) return false;
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(1)))));
        System.out.println(new Solution().isPalindrome(l));
    }
}
