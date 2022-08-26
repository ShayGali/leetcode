package algorithms.classes;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public void print() {
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
