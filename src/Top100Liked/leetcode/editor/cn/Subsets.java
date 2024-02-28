// 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,2,3]
// 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// 示例 2：
//
//
// 输入：nums = [0]
// 输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同
//
//
// Related Topics 位运算 数组 回溯 👍 2254 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        System.out.println(solution.subsets(new int[] {1, 2, 3}));
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(nums, new ArrayDeque<>(), 0, ans);
            return ans;
        }

        private void dfs(int[] nums, Deque<Integer> path, int start, List<List<Integer>> res) {
            res.add(new ArrayList<>(path));
            if (start == nums.length) {
                return;
            }
            for (int i = start; i < nums.length; i++) {
                path.addLast(nums[i]);
                dfs(nums, path, i + 1, res);
                path.removeLast();
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
