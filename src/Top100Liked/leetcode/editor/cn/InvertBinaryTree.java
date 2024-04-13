//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1784 👎 0


package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();

        // Test case 1
        TreeNode root1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode expected1 = new TreeNode(4, new TreeNode(7, new TreeNode(9), new TreeNode(6)), new TreeNode(2, new TreeNode(3), new TreeNode(1)));
        TreeNode result1 = solution.invertTree(root1);
        System.out.println("Test case 1: " + (result1.equals(expected1) ? "Passed" : "Failed"));

        // Test case 2
        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode expected2 = new TreeNode(2, new TreeNode(3), new TreeNode(1));
        TreeNode result2 = solution.invertTree(root2);
        System.out.println("Test case 2: " + (result2.equals(expected2) ? "Passed" : "Failed"));

        // Test case 3
        TreeNode root3 = null;
        TreeNode expected3 = null;
        TreeNode result3 = solution.invertTree(root3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.removeFirst();
                    if (treeNode.left != null) {
                        queue.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.addLast(treeNode.right);
                    }
                    TreeNode temp = treeNode.left;
                    treeNode.left = treeNode.right;
                    treeNode.right = temp;
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}