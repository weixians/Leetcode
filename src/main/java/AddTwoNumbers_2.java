/**
 * Program: LeetCode
 * Description: Medium难度；两个链表相加
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class AddTwoNumbers_2 {

    /**
     * 2ms
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int temp = carry;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            carry = temp / 10;
            temp = temp % 10;
            if (node == null) {
                node = new ListNode(temp);
            } else {
                node = new ListNode(temp, node);
            }
        }
        if (carry != 0) {
            node = new ListNode(carry, node);
        }
        ListNode result = null;
        while (node != null) {
            if (result == null) {
                result = new ListNode(node.val);
            } else {
                result = new ListNode(node.val, result);
            }
            node = node.next;
        }
        return result;
    }

    /**
     * 不用新建listnode，时间和空间和上面一样
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode node = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int temp = carry;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            carry = temp / 10;
            temp = temp % 10;
            if (node == null) {
                node = new ListNode(temp);
            } else {
                node = new ListNode(temp, node);
            }
        }
        if (carry != 0) {
            node = new ListNode(carry, node);
        }
        ListNode preNode = null;
        ListNode nextNode = null;
        while (node != null) {
            nextNode = node.next;
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        return preNode;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode last = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int temp = carry;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            carry = temp / 10;
            temp = temp % 10;
            if (last == null) {
                ListNode node = new ListNode(temp);
                head = node;
                last = node;
            } else {
                last.next = new ListNode(temp);
                last = last.next;
            }
        }
        if (carry != 0) {
            last.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbers_2 atn = new AddTwoNumbers_2();

    }

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
    }

}
