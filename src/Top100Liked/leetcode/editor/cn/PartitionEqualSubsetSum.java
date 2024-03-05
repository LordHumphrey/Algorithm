// 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,5,11,5]
// 输出：true
// 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//
// 示例 2：
//
//
// 输入：nums = [1,2,3,5]
// 输出：false
// 解释：数组不能分割成两个元素和相等的子集。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
//
// Related Topics 数组 动态规划 👍 2018 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();

        int[] nums = {1, 5, 11, 5};
        boolean result = solution.canPartition(nums);
        System.out.println(result); // Expected output: true

        nums = new int[] {1, 2, 3, 5};
        result = solution.canPartition(nums);
        System.out.println(result); // Expected output: false
        nums = new int[] {3, 3, 3, 4, 5};
        result = solution.canPartition(nums);
        System.out.println(result); // Expected output: false
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int len = nums.length;
            if (0 == len) {
                return false;
            }
            int sum = Arrays.stream(nums).sum();
            if (0 != sum % 2) {
                return false;
            }
            int half = sum / 2;
            boolean[] dp = new boolean[half + 1];
            dp[0] = true;
            for (int num : nums) {
                for (int i = half; i >= num; i--) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
            return dp[half];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
