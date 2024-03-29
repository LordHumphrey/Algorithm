// 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
//
//
//
// 示例 1：
//
//
// 输入：candidates = [2,3,6,7], target = 7
// 输出：[[2,2,3],[7]]
// 解释：
// 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
// 7 也是一个候选， 7 = 7 。
// 仅有这两种组合。
//
// 示例 2：
//
//
// 输入: candidates = [2,3,5], target = 8
// 输出: [[2,2,2,2],[2,3,3],[3,5]]
//
// 示例 3：
//
//
// 输入: candidates = [2], target = 1
// 输出: []
//
//
//
//
// 提示：
//
//
// 1 <= candidates.length <= 30
// 2 <= candidates[i] <= 40
// candidates 的所有元素 互不相同
// 1 <= target <= 40
//
//
// Related Topics 数组 回溯 👍 2751 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();

        // Test case 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        List<List<Integer>> expected1 = new ArrayList<>();
        expected1.add(Arrays.asList(2, 2, 3));
        expected1.add(Arrays.asList(7));
        List<List<Integer>> result1 = solution.combinationSum(candidates1, target1);
        System.out.println("Test case 1: " + (expected1.equals(result1) ? "Passed" : "Failed"));

        // Test case 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        List<List<Integer>> expected2 = new ArrayList<>();
        expected2.add(Arrays.asList(2, 2, 2, 2));
        expected2.add(Arrays.asList(2, 3, 3));
        expected2.add(Arrays.asList(3, 5));
        List<List<Integer>> result2 = solution.combinationSum(candidates2, target2);
        System.out.println("Test case 2: " + (expected2.equals(result2) ? "Passed" : "Failed"));

        // Test case 3
        int[] candidates3 = {2};
        int target3 = 1;
        List<List<Integer>> expected3 = new ArrayList<>();
        List<List<Integer>> result3 = solution.combinationSum(candidates3, target3);
        System.out.println("Test case 3: " + (expected3.equals(result3) ? "Passed" : "Failed"));
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(candidates, target, 0, 0, new ArrayDeque<>(), res);
            return res;
        }

        private void dfs(
                int[] candidates, int target, int sum, int start, Deque<Integer> path, List<List<Integer>> res) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            } else if (sum > target) {
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                path.add(candidates[i]);
                sum += candidates[i];
                dfs(candidates, target, sum, i, path, res);
                sum -= candidates[i];
                path.removeLast();
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
