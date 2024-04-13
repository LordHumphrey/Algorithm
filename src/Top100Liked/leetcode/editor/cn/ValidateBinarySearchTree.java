// 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下：
//
//
// 节点的左子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
//
//
// 示例 1：
//
//
// 输入：root = [2,1,3]
// 输出：true
//
//
// 示例 2：
//
//
// 输入：root = [5,1,4,null,null,3,6]
// 输出：false
// 解释：根节点的值是 5 ，但是右子节点的值是 4 。
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在[1, 10⁴] 内
// -2³¹ <= Top100Liked.leetcode.editor.cn.Node.val <= 2³¹ - 1
//
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2300 👎 0

package Top100Liked.leetcode.editor.cn;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();

        // Test case 1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        boolean result1 = solution.isValidBST(root1);
        System.out.println(result1 ? "Test case 1 passed" : "Test case 1 failed");

        // Test case 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        boolean result2 = solution.isValidBST(root2);
        System.out.println(!result2 ? "Test case 2 passed" : "Test case 2 failed");
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


        public boolean isValidBST(TreeNode root) {
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
