package algorithms.easy.remove_linked_list_elements_203;

import algorithms.classes.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        if (head == null) return null;

        ListNode temp = head;

        while (temp != null) {
            while (temp.next != null && temp.next.val == val)
                temp.next = temp.next.next;

            temp = temp.next;
        }
        return head;
    }


    // רקוסיית זנב - נגיע לסוף - אם הval של אותו אחד שווה למה שאנחנו רוצים להסיר
    // אז נחזיר את הnext שלו לזה שקרא לו
    public ListNode removeElementsRecursive(ListNode current, int val) {
        if (current == null) return null; // כשהגענו לסוף נחזיר null

        current.next = removeElementsRecursive(current.next, val);// רקוסריית זנב - נקח את ההבא של עם הקריאה של הצומת הבאה

        if (current.val == val) return current.next; // אם הוא שווה אז נחזיר את הבא

        return current; // אם הוא שונה אז נחזיר את אותו אחד
    }
}