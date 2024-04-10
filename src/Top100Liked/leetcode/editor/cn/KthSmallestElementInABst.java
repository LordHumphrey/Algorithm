/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 10⁴
 * 0 <= Top100Liked.leetcode.editor.cn.Node.val <= 10⁴
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 * <p>
 * Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 821 👎 0
 */
package Top100Liked.leetcode.editor.cn;

public class KthSmallestElementInABst {
    public static void main(String[] args) {
        KthSmallestElementInABst kthSmallestElementInABst = new KthSmallestElementInABst();
        Solution solution = kthSmallestElementInABst.new Solution();

        // Create a binary search tree for testing
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);

        // Call the kthSmallest method
        int k = 3;
        int result = solution.kthSmallest(root, k);

        // Print the result
        System.out.println("The " + k + "th smallest element in the BST is: " + result);
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
        int ans = 0, k = Integer.MIN_VALUE;

        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            middleOrderTraversal(root);
            return ans;
        }

        private void middleOrderTraversal(TreeNode root) {
            if (root == null || k < 0) {
                return;
            }
            middleOrderTraversal(root.left);
            k--;
            if (k == 0) {
                ans = root.val;
            }
            middleOrderTraversal(root.right);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
