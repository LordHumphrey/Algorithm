// 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//
// 你可以认为每种硬币的数量是无限的。
//
//
//
// 示例 1：
//
//
// 输入：coins = [1, 2, 5], amount = 11
// 输出：3
// 解释：11 = 5 + 5 + 1
//
// 示例 2：
//
//
// 输入：coins = [2], amount = 3
// 输出：-1
//
// 示例 3：
//
//
// 输入：coins = [1], amount = 0
// 输出：0
//
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 2³¹ - 1
// 0 <= amount <= 10⁴
//
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2721 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = solution.coinChange(coins, amount);
        System.out.println("The minimum number of coins needed is: " + result);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int length = coins.length;
            if (length == 0) {
                return 0;
            }
            if (amount == 0) {
                return 0;
            }
            int[][] dp = new int[length + 1][amount + 1];
            for (int[] ints : dp) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
            dp[0][0] = 0;
            for (int i = 1; i < length + 1; i++) {
                for (int i1 = 0; i1 < amount + 1; i1++) {
                    if (coins[i - 1] <= i1 && dp[i][i1 - coins[i1 - 1]] != Integer.MAX_VALUE) {
                        dp[i][i1] = Math.min(dp[i][i1 - coins[i1 - 1]] + 1, dp[i - 1][i1]);
                    } else {
                        dp[i][i1] = dp[i - 1][i1];
                    }
                }
            }
            return dp[length][amount] == Integer.MAX_VALUE ? -1 : dp[length][amount];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
