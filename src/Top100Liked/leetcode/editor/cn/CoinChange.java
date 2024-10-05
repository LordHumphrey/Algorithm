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
        System.out.println("Test case 1 - coins: [1, 2, 5], amount: 11 - " + (expected1 == result1 ? "Passed" : "Failed"));

        // Test case 2
        int[] coins2 = {2};
        int amount2 = 3;
        int expected2 = -1;
        int result2 = solution.coinChange(coins2, amount2);
        System.out.println("Test case 2 - coins: [2], amount: 3 - " + (expected2 == result2 ? "Passed" : "Failed"));

        // Test case 3
        int[] coins3 = {1};
        int amount3 = 0;
        int expected3 = 0;
        int result3 = solution.coinChange(coins3, amount3);
        System.out.println("Test case 3 - coins: [1], amount: 0 - " + (expected3 == result3 ? "Passed" : "Failed"));

        // Test case 4
        int[] coins4 = {186, 419, 83, 408};
        int amount4 = 6249;
        int expected4 = 20;
        int result4 = solution.coinChange(coins4, amount4);
        System.out.println("Test case 4 - coins: [186, 419, 83, 408], amount: 6249 - " + (expected4 == result4 ? "Passed" : "Failed"));

        // Additional Test case 5
        int[] coins5 = {2};
        int amount5 = 3;
        int expected5 = -1;
        int result5 = solution.coinChange(coins5, amount5);
        System.out.println("Test case 5 - coins: [2], amount: 3 - " + (expected5 == result5 ? "Passed" : "Failed"));
    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 递归的决策过程：
         * 对于每个硬币，我们有两种选择：
         * a. 不使用这个硬币：dp[coinIdx + 1][subAmount] = dp[coinIdx][subAmount]
         * b. 使用这个硬币：dp[coinIdx + 1][subAmount] = dp[coinIdx + 1][subAmount - coin] + 1
         * <p>
         * 递归到动态规划的转化：
         * <p>
         * dp[coinIdx][subAmount] 表示使用前 coinIdx 个硬币凑成 subAmount 所需的最少硬币数
         * 外层循环 (coinIdx) 相当于递归的不同层级
         * 内层循环 (subAmount) 相当于在每个递归层级中尝试不同的剩余金额
         *
         * @param coins
         * @param amount
         * @return
         */
        public int coinChange(int[] coins, int amount) {
        
            return -1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
