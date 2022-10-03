//package algorithms.medium.reverse_linked_List_II_94;
//
//import algorithms.classes.ListNode;
//
//public class Solution {
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        ListNode prev = null, next;
//        int i = 0;
//        while (i<right){
//            prev = head;
//        }
//    }
//
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null, next;
//        while (head != null) {
//            next = head.next;
//            head.next = prev;
//            prev = head;
//            head = next;
//        }
//        return prev;
//    }
//}
