// 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
// 返回其根节点。
//
//
//
// 示例 1:
//
//
// 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// 输出: [3,9,20,null,null,15,7]
//
//
// 示例 2:
//
//
// 输入: preorder = [-1], inorder = [-1]
// 输出: [-1]
//
//
//
//
// 提示:
//
//
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder 和 inorder 均 无重复 元素
// inorder 均出现在 preorder
// preorder 保证 为二叉树的前序遍历序列
// inorder 保证 为二叉树的中序遍历序列
//
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2264 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        assertTreeEqual(
                solution.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7}),
                new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))); // Test passed
        assertTreeEqual(solution.buildTree(new int[] {-1}, new int[] {-1}), new TreeNode(-1)); // Test passed
    }

    public static void assertTreeEqual(TreeNode actual, TreeNode expected) {
        if (isSameTree(actual, expected)) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            List<Integer> preorderList = Arrays.stream(preorder).boxed().toList();
            List<Integer> inorderList = Arrays.stream(inorder).boxed().toList();
            Deque<Integer> preOrderQueue = new ArrayDeque<>(preorderList);
            return dfs(inorderList, preOrderQueue, 0, preorder.length - 1);
        }

        public TreeNode dfs(List<Integer> inOrder, Deque<Integer> preOrderQueue, int start, int end) {
            if (start > end) {
                return null;
            }
            Integer head = preOrderQueue.removeFirst();
            int idx = inOrder.indexOf(head);
            TreeNode treeNode = new TreeNode(head);
            treeNode.left = dfs(inOrder, preOrderQueue, start, idx - 1);
            treeNode.right = dfs(inOrder, preOrderQueue, idx + 1, end);
            return treeNode;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}
