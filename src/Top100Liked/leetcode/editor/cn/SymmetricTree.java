//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2698 👎 0


package Top100Liked.leetcode.editor.cn;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();

        // Test case 1: Completely symmetric binary tree
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(2);
        tree1.left.left = new TreeNode(3);
        tree1.left.right = new TreeNode(4);
        tree1.right.left = new TreeNode(4);
        tree1.right.right = new TreeNode(3);
        System.out.println("Test case 1: " + (solution.isSymmetric(tree1) == true ? "Passed" : "Failed"));

        // Test case 2: Partially symmetric binary tree
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(2);
        tree2.left.right = new TreeNode(3);
        tree2.right.right = new TreeNode(3);
        System.out.println("Test case 2: " + (solution.isSymmetric(tree2) == false ? "Passed" : "Failed"));

        // Test case 3: Completely asymmetric binary tree
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(3);
        tree3.left.left = new TreeNode(4);
        tree3.left.right = new TreeNode(5);
        tree3.right.left = new TreeNode(6);
        tree3.right.right = new TreeNode(7);
        System.out.println("Test case 3: " + (solution.isSymmetric(tree3) == false ? "Passed" : "Failed"));
        // New test case: Partially symmetric binary tree with additional node
        TreeNode tree4 = new TreeNode(1);
        tree4.left = new TreeNode(2);
        tree4.right = new TreeNode(2);
        tree4.left.left = new TreeNode(2);
        tree4.right.left = new TreeNode(2);
        System.out.println("Test case 4: " + (solution.isSymmetric(tree4) == false ? "Passed" : "Failed"));

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
        public boolean isSymmetric(TreeNode root) {
            return dfsIsSymmetric(root.left, root.right);
        }

        private boolean dfsIsSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return dfsIsSymmetric(left.right, right.left) && dfsIsSymmetric(right.right, left.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}