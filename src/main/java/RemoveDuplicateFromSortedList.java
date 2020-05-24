/**
 * Program: LeetCode
 * Description: Easy
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class RemoveDuplicateFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode node;
        while ((node = pre.next) != null) {
            if (node.val == pre.val) {
                pre.next = node.next;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicateFromSortedList tc = new RemoveDuplicateFromSortedList();

    }

    public class ListNode {
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

