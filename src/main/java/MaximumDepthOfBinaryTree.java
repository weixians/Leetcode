/**
 * Program: LeetCode
 * Description: Easy
 * Author: Weixian Shi
 * Time: 2020-05-03 21:59
 **/
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        return getDepth(root, 1);
    }

    private int getDepth(TreeNode node, int depth) {
        //stop condition
        if (node.left == null && node.right == null) {
            return depth;
        }
        int maxLen = 0;
        if (node.left != null) {
            maxLen = getDepth(node.left, depth + 1);
        }
        if (node.right != null) {
            int len = getDepth(node.right, depth + 1);
            if (len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree tc = new MaximumDepthOfBinaryTree();

    }
}
