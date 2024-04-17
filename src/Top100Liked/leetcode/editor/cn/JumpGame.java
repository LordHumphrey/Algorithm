// 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
// 输入：nums = [2,3,1,1,4]
// 输出：true
// 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
//
// 示例 2：
//
//
// 输入：nums = [3,2,1,0,4]
// 输出：false
// 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// 0 <= nums[i] <= 10⁵
//
//
// Related Topics 贪心 数组 动态规划 👍 2699 👎 0

package Top100Liked.leetcode.editor.cn;

public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();

        // Test case 1
        int[] nums1 = {2, 3, 1, 1, 4};
        boolean result1 = solution.canJump(nums1);
        System.out.println(result1 ? "Test case 1 passed" : "Test case 1 failed");

        // Test case 2
        int[] nums2 = {3, 2, 1, 0, 4};
        boolean result2 = solution.canJump(nums2);
        System.out.println(!result2 ? "Test case 2 passed" : "Test case 2 failed");

        // Test case 3
        int[] nums3 = {0};
        boolean result3 = solution.canJump(nums3);
        System.out.println(result3 ? "Test case 3 passed" : "Test case 3 failed");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (cnt < i) {
                    return false;
                }
                cnt = Math.max(cnt, i + nums[i]);
            }
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
