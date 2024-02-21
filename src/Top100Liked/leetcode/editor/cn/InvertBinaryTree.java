// 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
//
//
// 示例 1：
//
//
//
//
// 输入：root = [4,2,7,1,3,6,9]
// 输出：[4,7,2,9,6,3,1]
//
//
// 示例 2：
//
//
//
//
// 输入：root = [2,1,3]
// 输出：[2,3,1]
//
//
// 示例 3：
//
//
// 输入：root = []
// 输出：[]
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
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1770 👎 0

package Top100Liked.leetcode.editor.cn;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();

        // Create a binary tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Call the invertNodeReverse function
        TreeNode invertedRoot = solution.invertNodeReverse(root);

        // Print the inverted tree
        printTree(invertedRoot);
    }

    public static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }

        printTree(node.left);
        System.out.print(" " + node.val + " ");
        printTree(node.right);
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
        public TreeNode invertTree(TreeNode root) {
            return invertNodeReverse(root);
        }

        private TreeNode invertNodeReverse(TreeNode root) {
            if (null == root) {
                return null;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.right = invertNodeReverse(left);
            root.left = invertNodeReverse(right);
            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
