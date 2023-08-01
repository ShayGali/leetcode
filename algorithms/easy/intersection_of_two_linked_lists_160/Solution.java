package algorithms.easy.intersection_of_two_linked_lists_160;

import algorithms.classes.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = 0, m = 0;
        ListNode temp1, temp2;

        // find the length of list A
        temp1 = headA;
        while (temp1 != null) {
            n++;
            temp1 = temp1.next;
        }

        // find the length of list B
        temp2 = headB;
        while (temp2 != null) {
            m++;
            temp2 = temp2.next;
        }


        temp1 = headA;
        temp2 = headB;

        // put the pointers in the same level
        while (n > m) {
            n--;
            temp1 = temp1.next;
        }

        while (m > n) {
            m--;
            temp2 = temp2.next;
        }

        // run until the intersection (or until null)
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
    }
}
