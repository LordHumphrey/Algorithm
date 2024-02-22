/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 *
 *
 * 示例 2:
 *
 *
 * 输入: [1,null,3]
 * 输出: [1,3]
 *
 *
 * 示例 3:
 *
 *
 * 输入: []
 * 输出: []
 *
 *
 *
 *
 * 提示:
 *
 *
 * 二叉树的节点个数的范围是 [0,100]
 *
 * -100 <= Node.val <= 100
 *
 *
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1031 👎 0
 *
 */
package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        Solution solution = binaryTreeRightSideView.new Solution();

        // Create a binary tree for testing
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // Call the rightSideView method
        List<Integer> result = solution.rightSideView(root);

        // Print the result
        System.out.println("The right side view of the binary tree is: " + result);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            rightSideViewSolve(root, res);
            return res;
        }

        public void rightSideViewSolve(TreeNode root, List<Integer> res) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            if (null == root) {
                return;
            } else {
                deque.addLast(root);
            }

            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = deque.pollFirst();
                    if (i == size - 1) {
                        if (treeNode != null) {
                            res.add(treeNode.val);
                        }
                    }
                    if (treeNode != null && treeNode.left != null) {
                        deque.addLast(treeNode.left);
                    }
                    if (treeNode != null && treeNode.right != null) {
                        deque.addLast(treeNode.right);
                    }
                }
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
