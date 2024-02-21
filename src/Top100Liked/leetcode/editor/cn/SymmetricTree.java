// <p>给你一个二叉树的根节点 <code>root</code> ， 检查它是否轴对称。</p>
//
// <p>&nbsp;</p>
//
// <p><strong>示例 1：</strong></p>
// <img alt="" src="https://pic.leetcode.cn/1698026966-JDYPDU-image.png" style="width: 354px; height: 291px;" />
// <pre>
// <strong>输入：</strong>root = [1,2,2,3,4,4,3]
// <strong>输出：</strong>true
// </pre>
//
// <p><strong>示例 2：</strong></p>
// <img alt="" src="https://pic.leetcode.cn/1698027008-nPFLbM-image.png" style="width: 308px; height: 258px;" />
// <pre>
// <strong>输入：</strong>root = [1,2,2,null,3,null,3]
// <strong>输出：</strong>false
// </pre>
//
// <p>&nbsp;</p>
//
// <p><strong>提示：</strong></p>
//
// <ul>
// <li>树中节点数目在范围 <code>[1, 1000]</code> 内</li>
// <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
// </ul>
//
// <p>&nbsp;</p>
//
// <p><strong>进阶：</strong>你可以运用递归和迭代两种方法解决这个问题吗？</p>
//
// <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍
// 2651</li><li>👎 0</li></div>

package Top100Liked.leetcode.editor.cn;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            return checkSymmetric(root.left, root.right);
        }

        private boolean checkSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return checkSymmetric(left.right, right.left) && checkSymmetric(left.left, right.right);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
