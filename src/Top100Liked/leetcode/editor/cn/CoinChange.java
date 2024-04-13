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
// Related Topics 广度优先搜索 数组 动态规划 👍 2791 👎 0

package Top100Liked.leetcode.editor.cn;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();

        // Test case 1
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int expected1 = 3;
        int result1 = solution.coinChange(coins1, amount1);
        System.out.println("Test case 1: " + (expected1 == result1 ? "Passed" : "Failed"));

        // Test case 2
        int[] coins2 = {2};
        int amount2 = 3;
        int expected2 = -1;
        int result2 = solution.coinChange(coins2, amount2);
        System.out.println("Test case 2: " + (expected2 == result2 ? "Passed" : "Failed"));

        // Test case 3
        int[] coins3 = {1};
        int amount3 = 0;
        int expected3 = 0;
        int result3 = solution.coinChange(coins3, amount3);
        System.out.println("Test case 3: " + (expected3 == result3 ? "Passed" : "Failed"));

        int[] coins4 = {186, 419, 83, 408};
        int amount4 = 6249;
        int expected4 = 20;
        int result4 = solution.coinChange(coins4, amount4);
        System.out.println("Test case 4: " + (expected4 == result4 ? "Passed" : "Failed"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int length = coins.length;
            int[][] dp = new int[length][amount + 1];
            for (int i = 0; i <= amount; i++) {
                if (i % coins[0] == 0) {
                    dp[0][i] = i / coins[0];
                } else {
                    dp[0][i] = Integer.MAX_VALUE;
                }
            }
            for (int i = 1; i < length; i++) {
                int coin = coins[i];
                for (int j = 0; j <= amount; j++) {
                    dp[i][j] = dp[i - 1][j];
                    for (int k = 1; k * coin <= j; k++) {
                        if (j >= coin && dp[i][j - k * coin] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j - k * coin] + k, dp[i][j]);
                        } else {
                            dp[i][j] = dp[i][j];
                        }
                    }
                }
            }
            return dp[length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[length - 1][amount];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
