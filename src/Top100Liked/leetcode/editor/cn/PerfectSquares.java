// 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
//
//
//
//
// 示例 1：
//
//
// 输入：n = 12
// 输出：3
// 解释：12 = 4 + 4 + 4
//
// 示例 2：
//
//
// 输入：n = 13
// 输出：2
// 解释：13 = 4 + 9
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁴
//
//
// Related Topics 广度优先搜索 数学 动态规划 👍 1921 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        Solution solution = perfectSquares.new Solution();
        int testInput = 12;
        int result = solution.numSquares(testInput);
        System.out.println("The minimum number of perfect squares for " + testInput + " is: " + result);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            List<Integer> list = new ArrayList<>();
            int idx = 1;
            while (idx * idx <= n) {
                list.add(idx * idx);
                idx++;
            }
            int size = list.size(), first = list.getFirst();
            int[][] dp = new int[size][n + 1];
            for (int i = 0; i <= n; i++) {
                if (i % first == 0) {
                    dp[0][i] = i / first;
                } else {
                    dp[0][i] = Integer.MAX_VALUE;
                }
            }
            for (int i = 1; i < size; i++) {
                int t = list.get(i);
                for (int j = 0; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j];
                    for (int k = 1; k * t <= j; k++) {
                        if (dp[i - 1][j - k * t] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i - 1][j - k * t] + k, dp[i][j]);
                            //                            dp[i][j] = Math.min(dp[i][j - k * t] + k, dp[i - 1][j]);
                        }
                    }
                }
            }
            return dp[size - 1][n] == Integer.MAX_VALUE ? -1 : dp[size - 1][n];
        }

        private int dfs(int[] nums, int n) {
            if (n <= 0) {
                return 0;
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i * i <= n; i++) {
                ans = Math.min(ans, dfs(nums, n - i * i) + 1);
            }
            return ans;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
}
