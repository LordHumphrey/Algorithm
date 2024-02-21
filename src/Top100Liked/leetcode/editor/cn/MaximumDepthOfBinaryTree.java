// 给定一个二叉树 root ，返回其最大深度。
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
//
//
//
// 示例 1：
//
//
//
//
//
//
// 输入：root = [3,9,20,null,null,15,7]
// 输出：3
//
//
// 示例 2：
//
//
// 输入：root = [1,null,2]
// 输出：2
//
//
//
//
// 提示：
//
//
// 树中节点的数量在 [0, 10⁴] 区间内。
// -100 <= Node.val <= 100
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1778 👎 0

package Top100Liked.leetcode.editor.cn;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();

        // Create a binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Call the maxDepth function
        int maxDepth = solution.maxDepth(root);

        // Print the result
        System.out.println("The maximum depth of the binary tree is: " + maxDepth);
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
        public int maxDepth(TreeNode root) {
            if (null == root) {
                return 0;
            }
            int res = 0;
            res = orderTraversalTreeReverse(root, res);
            return res;
        }

        private int orderTraversalTreeReverse(TreeNode root, int res) {
            if (null == root) {
                return 0;
            } else {
                return Math.max(orderTraversalTreeReverse(root.left, res), orderTraversalTreeReverse(root.right, res))
                        + 1;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
