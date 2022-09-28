package algorithms.medium.remove_Nth_node_from_end_19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            return val + " --> " + next;
        }
    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        Map<Integer, ListNode> map = new HashMap<>();
//        ListNode temp = head;
//        int i = 1;
//        while (temp != null) {
//            map.put(i++, temp);
//            temp = temp.next;
//        }
//        ListNode l = map.get(map.size() - n);
//        if (l != null) {
//            l.next = map.get(map.size() - n + 2);
//            return head;
//        }
//        return head.next;
//    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode temp = head;
//        ListNode temp2 = head;
//        int counter = 0;
//        while (temp != null) {
//            if (counter++ > n) temp2 = temp2.next;
//            temp = temp.next;
//        }
//        if (temp2 == null) return null;
//        if (temp2 == head) return head.next;
//        if (temp2.next == null)
//            return null;
//        temp2.next = temp2.next.next;
//        return head;
//    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null)
            return head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }


    public static void main(String[] args) {
//        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode l = new ListNode(1, new ListNode(2));
//        ListNode l = new ListNode(1);
//        System.out.println(l);
        System.out.println(new Solution().removeNthFromEnd(l, 2));
    }
}
