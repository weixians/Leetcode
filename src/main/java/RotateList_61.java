/**
 * Program: LeetCode
 * Description: Medium
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode node = head;
        ListNode lastNode = null;
        //链表元素计数
        while (node != null) {
            size++;
            lastNode = node;
            node = node.next;
        }
        if (size <= 0) {
            return head;
        }
        //计算要开始旋转链表的支点
        int pos = size - k % size;
        //调换
        node = head;
        ListNode preNode = null;
        for (int i = 0; i < pos; i++) {
            preNode = node;
            node = node.next;
        }
        //判断node是否为null主要是为了防止只有一个元素的情况
        if (preNode == null || node == null) {
            return head;
        }
        preNode.next = null;
        lastNode.next = head;
        head = node;
        return head;
    }

    public static void main(String[] args) {
        RotateList_61 tc = new RotateList_61();
        ListNode node = new ListNode(5);
//        node = new ListNode(4, node);
//        node = new ListNode(3, node);
//        node = new ListNode(2, node);
//        node = new ListNode(1, node);
//        ListNode node = new ListNode(2);
//        node = new ListNode(1, node);
//        node = new ListNode(0, node);
        ListNode result = tc.rotateRight(node, 0);

        while (result != null) {
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }
}
