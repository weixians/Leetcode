/**
 * Program: LeetCode
 * Description: Easy
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSymmetric(root.left, root.right);
        }
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if ((p == null && q == null)) {
            return true;
        } else if ((p != null && q != null && p.val == q.val)) {
            boolean same = isSymmetric(p.left, q.right);
            if (same) {
                return isSymmetric(p.right, q.left);
            }
            return false;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        SymmetricTree tc = new SymmetricTree();

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
