package algorithms.easy.remove_duplicates_from_sorted_list_83;

import algorithms.classes.ListNode;

public class Solution {
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;
        ListNode temp = head;
//        while (temp != null) {
//            while (temp.next != null && temp.val == temp.next.val)
//                temp.next = temp.next.next;
//            temp = temp.next;
//        }
        while (temp.next != null)
            if (temp.val == temp.next.val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) return head.next;
        return head;
    }
}
