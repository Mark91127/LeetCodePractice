package easy;

public class Question206 {
    public ListNode reverseList(ListNode head) {
        ListNode front = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempNext = curr.next;
            curr.next = front;
            front = curr;
            curr = tempNext;
        }
        return front;
    }

    public static class ListNode {
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
    }
}
