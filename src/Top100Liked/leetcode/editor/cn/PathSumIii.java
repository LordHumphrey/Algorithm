// 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
//
//
// 示例 1：
//
//
//
//
// 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
// 输出：3
// 解释：和等于 8 的路径有 3 条，如图所示。
//
//
// 示例 2：
//
//
// 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// 输出：3
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [0,1000]
//
// -10⁹ <= Node.val <= 10⁹
// -1000 <= targetSum <= 1000
//
//
// Related Topics 树 深度优先搜索 二叉树 👍 1806 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.HashMap;

public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();

        // 创建一个二叉树
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        // 调用 pathSum 函数
        int targetSum = 8;
        int result = solution.pathSum(root, targetSum);

        // 打印结果
        System.out.println(result);
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

        int target;
        HashMap<Long, Integer> prefixSumNum;

        public int pathSum(TreeNode root, int targetSum) {
            target = targetSum;
            prefixSumNum = new HashMap<>();
            prefixSumNum.put(0L, 1);
            return recurPathSum(root, 0L);
        }

        private int recurPathSum(TreeNode node, Long curSum) {
            if (null == node) {
                return 0;
            }
            int res = 0;
            curSum += node.val;
            res += prefixSumNum.getOrDefault(curSum - target, 0);
            prefixSumNum.put(curSum, prefixSumNum.getOrDefault(curSum, 0) + 1);
            res += recurPathSum(node.left, curSum);
            res += recurPathSum(node.right, curSum);
            prefixSumNum.put(curSum, prefixSumNum.get(curSum) - 1);
            return res;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
}
