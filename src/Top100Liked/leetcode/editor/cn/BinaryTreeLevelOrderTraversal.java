// <p>给你二叉树的根节点 <code>root</code> ，返回其节点值的 <strong>层序遍历</strong> 。 （即逐层地，从左到右访问所有节点）。</p>
//
// <p>&nbsp;</p>
//
// <p><strong>示例 1：</strong></p>
// <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg" style="width: 277px; height: 302px;" />
// <pre>
// <strong>输入：</strong>root = [3,9,20,null,null,15,7]
// <strong>输出：</strong>[[3],[9,20],[15,7]]
// </pre>
//
// <p><strong>示例 2：</strong></p>
//
// <pre>
// <strong>输入：</strong>root = [1]
// <strong>输出：</strong>[[1]]
// </pre>
//
// <p><strong>示例 3：</strong></p>
//
// <pre>
// <strong>输入：</strong>root = []
// <strong>输出：</strong>[]
// </pre>
//
// <p>&nbsp;</p>
//
// <p><strong>提示：</strong></p>
//
// <ul>
// <li>树中节点数目在范围 <code>[0, 2000]</code> 内</li>
// <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
// </ul>
//
// <div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1901</li><li>👎
// 0</li></div>

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();

        // Create a binary tree for testing
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Call the levelOrder method and print the result
        List<List<Integer>> result = solution.levelOrder(root);
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            if (null != root) {
                deque.addLast(root);
            }
            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> res = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.pollFirst();
                    res.add(node.val);
                    if (null != node.left) {
                        deque.addLast(node.left);
                    }
                    if (null != node.right) {
                        deque.addLast(node.right);
                    }
                }
                ans.add(res);
            }
            return ans;
        }
    } // leetcode submit region end(Prohibit modification and deletion)
}
