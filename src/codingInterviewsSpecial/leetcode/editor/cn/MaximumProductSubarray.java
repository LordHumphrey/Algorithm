// 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
// 测试用例的答案是一个 32-位 整数。
//
//
//
// 示例 1:
//
//
// 输入: nums = [2,3,-2,4]
// 输出: 6
// 解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
//
// 输入: nums = [-2,0,-1]
// 输出: 0
// 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 2 * 10⁴
// -10 <= nums[i] <= 10
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
//
//
// Related Topics 数组 动态规划 👍 2197 👎 0

package codingInterviewsSpecial.leetcode.editor.cn;

import java.util.Arrays;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        int[] test1 = {2, 3, -2, 4};
        int[] test2 = {-2, 0, -1};
        int[] test3 = {-2, 3, -4};
        System.out.println(solution.maxProduct(test1)); // Expected output: 6
        System.out.println(solution.maxProduct(test2)); // Expected output: 0
        System.out.println(solution.maxProduct(test3)); // Expected output: 24
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int maxProduct(int[] nums) {
            int len = nums.length;
            if (len < 1) {
                return 0;
            }
            int[][] dp = new int[len][2];
            for (int i = 0; i < len; i++) {
                dp[i][0] = nums[i];
                dp[i][1] = nums[i];
            }
            for (int i = 1; i < len; i++) {
                if (nums[i] < 0) {
                    dp[i][0] = Math.min(dp[i][0], dp[i - 1][1] * nums[i]);
                    dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] * nums[i]);

                } else {
                    dp[i][0] = Math.min(dp[i][0], dp[i - 1][0] * nums[i]);
                    dp[i][1] = Math.max(dp[i][1], dp[i - 1][1] * nums[i]);
                }
            }
            return Arrays.stream(dp).mapToInt(arr -> arr[1]).max().orElse(Integer.MIN_VALUE);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
