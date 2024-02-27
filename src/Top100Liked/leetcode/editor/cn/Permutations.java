// 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,2,3]
// 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
// 输入：nums = [0,1]
// 输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
// 输入：nums = [1]
// 输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
//
// Related Topics 数组 回溯 👍 2819 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(nums, 0, res, new boolean[nums.length], new ArrayDeque<>());
            return res;
        }

        private void dfs(int[] nums, int start, List<List<Integer>> res, boolean[] used, Deque<Integer> path) {
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    path.addLast(nums[i]);
                    used[i] = true;
                    dfs(nums, i + 1, res, used, path);
                    used[i] = false;
                    path.removeLast();
                }
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
