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

import java.util.Arrays;

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
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                    System.out.println("i:" + i + " (i - j * j):" + (i - j * j) + " dp[i]:" + dp[i]
                            + " dp[i - j * j] + 1:" + (dp[i - j * j] + 1));
                }
            }
            return dp[n];
        }

        private int dfs(int n) {
            if (n == 0) {
                return 0;
            }
            int cnt = Integer.MAX_VALUE;
            for (int i = 1; i * i <= n; i++) {
                cnt = Math.min(cnt, dfs(n - i * i) + 1);
            }
            return cnt;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
