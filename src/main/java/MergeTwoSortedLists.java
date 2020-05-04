import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLists {
    /**
     * 最快，0ms
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode node = null;
        ListNode result = null;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                node = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node = new ListNode(l2.val);
                l2 = l2.next;
            }
            node.next = result;
            result = node;
        }
        ListNode rnode = null;
        while (result != null) {
            if (rnode == null) {
                rnode = new ListNode(result.val);
            } else {
                rnode = new ListNode(result.val, rnode);
            }
            result = result.next;
        }
        return rnode;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                list.add(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                list.add(l1.val);
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                list.add(l1.val);
                l1 = l1.next;
            } else {
                list.add(l2.val);
                l2 = l2.next;
            }
        }
        ListNode result = new ListNode();
        ListNode next = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            if ((next != null)) {
                result = new ListNode(list.get(i), next);
            } else {
                result = new ListNode(list.get(i));
            }
            next = result;
        }
        return result;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists model = new MergeTwoSortedLists();
        ListNode c = new ListNode(4);
        ListNode b = new ListNode(2, c);
        ListNode l1 = new ListNode(1, b);

        ListNode f = new ListNode(4);
        ListNode e = new ListNode(3, f);
        ListNode l2 = new ListNode(1, e);

        ListNode result = model.mergeTwoLists(l1, l2);

        result = model.mergeTwoLists(new ListNode(), new ListNode());
        System.out.println(result);
    }


}

class ListNode {
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