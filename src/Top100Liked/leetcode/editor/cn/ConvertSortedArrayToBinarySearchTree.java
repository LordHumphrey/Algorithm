// <p>给你一个整数数组 <code>nums</code> ，其中元素已经按 <strong>升序</strong> 排列，请你将其转换为一棵 <strong>高度平衡</strong> 二叉搜索树。</p>
//
// <p><strong>高度平衡 </strong>二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。</p>
//
// <p>&nbsp;</p>
//
// <p><strong>示例 1：</strong></p>
// <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree1.jpg" style="width: 302px; height: 222px;" />
// <pre>
// <strong>输入：</strong>nums = [-10,-3,0,5,9]
// <strong>输出：</strong>[0,-3,9,-10,null,5]
// <strong>解释：</strong>[0,-10,5,null,-3,null,9] 也将被视为正确答案：
// <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree2.jpg" style="width: 302px; height: 222px;" />
// </pre>
//
// <p><strong>示例 2：</strong></p>
// <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree.jpg" style="width: 342px; height: 142px;" />
// <pre>
// <strong>输入：</strong>nums = [1,3]
// <strong>输出：</strong>[3,1]
// <strong>解释：</strong>[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
// </pre>
//
// <p>&nbsp;</p>
//
// <p><strong>提示：</strong></p>
//
// <ul>
// <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
// <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
// <li><code>nums</code> 按 <strong>严格递增</strong> 顺序排列</li>
// </ul>
//
// <div><div>Related
// Topics</div><div><li>树</li><li>二叉搜索树</li><li>数组</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍
// 1474</li><li>👎 0</li></div>

package Top100Liked.leetcode.editor.cn;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();

        // Create an array for testing
        int[] nums = {-10, -3, 0, 5, 9};

        // Call the sortedArrayToBST method
        TreeNode root = solution.sortedArrayToBST(nums);

        // Print the result
        printInOrder(root);
    }

    // Helper method to print the tree in-order
    public static void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.val + " ");
            printInOrder(node.right);
        }
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBstDfs(nums, 0, nums.length - 1);
        }

        private TreeNode sortedArrayToBstDfs(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortedArrayToBstDfs(nums, start, mid - 1);
            node.right = sortedArrayToBstDfs(nums, mid + 1, end);
            return node;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}
