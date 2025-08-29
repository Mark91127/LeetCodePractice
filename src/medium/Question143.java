package medium;

import java.util.ArrayList;
import java.util.List;

public class Question143 {
    public void reorderList(ListNode head) {
        List<ListNode> order = new ArrayList<>();
        order.add(head);
        ListNode start = head.next;
        while (start != null) {
            order.add(start);
            start = start.next;
        }
        for (int i = 1; i < order.size(); i += 2) {
            order.add(i, order.removeLast());
        }
        for (int i = 1; i < order.size(); i++) {
            order.get(i - 1).next = order.get(i);
            if (i == order.size() - 1) {
                order.get(i).next = null;
            }
        }
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
