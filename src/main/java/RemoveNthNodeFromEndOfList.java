import java.util.List;

import java.util.ArrayList;

/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        List<ListNode> list = new ArrayList<>();
        while ((node != null)) {
            list.add(node);
            node = node.next;
        }
        if (list.size() > n) {
            node = list.get(list.size() - n - 1);
            if (node.next != null) {
                node.next = node.next.next;
            }
        } else {
            if (head != null) {
                head = head.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList tc = new RemoveNthNodeFromEndOfList();
        ListNode node = new ListNode(5, null);
        node = new ListNode(4, node);
        node = new ListNode(3, node);
        node = new ListNode(2, node);
        node = new ListNode(1, node);
        tc.removeNthFromEnd(node, 2);

        node = new ListNode(1, null);
        tc.removeNthFromEnd(node, 1);
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
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
