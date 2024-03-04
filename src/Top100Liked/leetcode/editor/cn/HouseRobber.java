// 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
// 被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
//
//
//
// 示例 1：
//
//
// 输入：[1,2,3,1]
// 输出：4
// 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//      偷窃到的最高金额 = 1 + 3 = 4 。
//
// 示例 2：
//
//
// 输入：[2,7,9,3,1]
// 输出：12
// 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400
//
//
// Related Topics 数组 动态规划 👍 2934 👎 0

package Top100Liked.leetcode.editor.cn;

public class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        int[] nums1 = {1, 2, 3, 1};
        int result1 = solution.rob(nums1);
        System.out.println("When nums = [1,2,3,1], the result is: " + result1);

        int[] nums2 = {2, 7, 9, 3, 1};
        int result2 = solution.rob(nums2);
        System.out.println("When nums = [2,7,9,3,1], the result is: " + result2);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int length = nums.length;
            int[][] ans = new int[length][2];
            ans[0][0] = 0;
            ans[0][1] = nums[0];
            for (int i = 1; i < length; i++) {
                ans[i][0] = Math.max(ans[i - 1][1], ans[i - 1][0]);
                ans[i][1] = Math.max(ans[i - 1][0] + nums[i], ans[i - 1][1]);
            }
            return Math.max(ans[length - 1][0], ans[length - 1][1]);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
