package medium.add_two_numbers;


//Definition for singly-linked list.
class ListNode {
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

    void print() {
        ListNode temp = this;
        System.out.print('[');
        while (temp.next != null) {
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
        System.out.println(temp.val + "]");
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        ListNode temp = this;
        while (temp.next != null) {
            str.append(temp.val).append(", ");
            temp = temp.next;
        }
        str.append(temp.val).append("]");
        return str.toString();
    }
}

class Solution {

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newL = new ListNode(0);
        ListNode temp = newL;

        int carry = 0;
        int n;

        while (l1 != null && l2 != null) {
            n = l1.val + l2.val + carry;
            temp.next = new ListNode(n % 10);
            carry = n / 10;

            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }

        while (l1 != null) {
            n = l1.val + carry;
            temp.next = new ListNode(n % 10);
            carry = n / 10;

            l1 = l1.next;
            temp = temp.next;
        }

        while (l2 != null) {
            n = l2.val + carry;
            temp.next = new ListNode(n % 10);
            carry = n / 10;

            l2 = l2.next;
            temp = temp.next;
        }

        while (carry != 0) {
            temp.next = new ListNode(carry % 10);
            carry /= 10;
        }

        return newL.next;
    }


    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        ListNode l1 = new ListNode(3, new ListNode(7));
        ListNode l2 = new ListNode(9, new ListNode(2));
//
//        ListNode l1 = new ListNode(9, new ListNode(8));
//        ListNode l2 = new ListNode(1);
        new Solution().addTwoNumbers(l1, l2).print();
    }


}