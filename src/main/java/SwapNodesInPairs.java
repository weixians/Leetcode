/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode node = head;
        ListNode preNode = null;
        while (node != null) {
            if (node == head) {
                if (node.next == null) {
                    return head;
                } else {
                    ListNode temp = head.next.next;
                    head = head.next;
                    node.next = temp;
                    head.next = node;
                }
            } else {
                if (node.next != null) {
                    ListNode temp = node.next.next;
                    preNode.next = node.next;
                    node.next.next = node;
                    node.next = temp;
                }
            }
            preNode = node;
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        SwapNodesInPairs tc = new SwapNodesInPairs();
        ListNode node = new ListNode(4);
        node = new ListNode(3, node);
        node = new ListNode(2, node);
        node = new ListNode(1, node);
        ListNode head = tc.swapPairs(node);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


}

