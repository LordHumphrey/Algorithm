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
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1806 👎 0

package Top100Liked.leetcode.editor.cn;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();

        // Test case 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        int expected1 = 3;
        int result1 = solution.maxDepth(root1);
        System.out.println("Test case 1: " + (expected1 == result1 ? "Passed" : "Failed"));

        // Test case 2
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        int expected2 = 2;
        int result2 = solution.maxDepth(root2);
        System.out.println("Test case 2: " + (expected2 == result2 ? "Passed" : "Failed"));

        // Test case 3
        TreeNode root3 = null;
        int expected3 = 0;
        int result3 = solution.maxDepth(root3);
        System.out.println("Test case 3: " + (expected3 == result3 ? "Passed" : "Failed"));

        // Test case 4
        TreeNode root4 = new TreeNode(0);
        int expected4 = 1;
        int result4 = solution.maxDepth(root4);
        System.out.println("Test case 4: " + (expected4 == result4 ? "Passed" : "Failed"));
    }
    // leetcode submit region begin(Prohibit modification and deletion)

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

        public int maxDepth(TreeNode root) {
            return dfs(root);
        }

        private int dfs(TreeNode root) {
            if (null == root) {
                return 0;
            } else {
                return 1 + Math.max(dfs(root.left), dfs(root.right));
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
