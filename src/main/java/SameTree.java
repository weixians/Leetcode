/**
 * Program: LeetCode
 * Description: 模板类
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q == null)) {
            return true;
        } else if ((p != null && q != null && p.val == q.val)) {
            boolean same = isSameTree(p.left, q.left);
            if (same) {
                return isSameTree(p.right, q.right);
            }
            return false;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        SameTree tc = new SameTree();

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
