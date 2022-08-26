package algorithms.medium.linked_list_cycle_II_142;

import algorithms.classes.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> s = new HashSet<>();
        while(head != null){
            if(s.contains(head))return head;
            s.add(head);
            head = head.next;
        }
        return null;
    }
}
