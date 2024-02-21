// 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
//
//
// 示例 1：
//
//
// 输入：root = [1,null,2,3]
// 输出：[1,3,2]
//
//
// 示例 2：
//
//
// 输入：root = []
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：root = [1]
// 输出：[1]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2039 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();

        // 创建一个二叉树
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // 调用 inorderTraversal 函数
        List<Integer> result = solution.inorderTraversal(root);

        // 打印结果
        System.out.println(result);
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     *
     * @author taowong
     * @date 2024/02/21
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (null == root) {
                return List.of();
            }
            List<Integer> res = new ArrayList<>();
            middleOrderTraversalTreeReverse(root, res);
            return res;
        }

        private void middleOrderTraversalTreeReverse(TreeNode root, List<Integer> res) {
            if (null == root) {
                return;
            }
            middleOrderTraversalTreeReverse(root.left, res);
            res.add(root.val);
            middleOrderTraversalTreeReverse(root.right, res);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
