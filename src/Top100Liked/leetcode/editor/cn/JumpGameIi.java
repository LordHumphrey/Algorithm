// 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
//
//
// 0 <= j <= nums[i]
// i + j < n
//
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
//
//
//
// 示例 1:
//
//
// 输入: nums = [2,3,1,1,4]
// 输出: 2
// 解释: 跳到最后一个位置的最小跳跃数是 2。
//      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 示例 2:
//
//
// 输入: nums = [2,3,0,1,4]
// 输出: 2
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁴
// 0 <= nums[i] <= 1000
// 题目保证可以到达 nums[n-1]
//
//
// Related Topics 贪心 数组 动态规划 👍 2478 👎 0

package Top100Liked.leetcode.editor.cn;

public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();

        // Test case 1
        int[] nums1 = {2, 3, 1, 1, 4};
        int expected1 = 2;
        int result1 = solution.jump(nums1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test case 2
        int[] nums2 = {2, 3, 0, 1, 4};
        int expected2 = 2;
        int result2 = solution.jump(nums2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test case 3
        int[] nums3 = {1, 2, 3};
        int expected3 = 2;
        int result3 = solution.jump(nums3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));

        // Test case 4
        int[] nums4 = {0};
        int expected4 = 0;
        int result4 = solution.jump(nums4);
        System.out.println("Test case 4: " + (result4 == expected4 ? "Passed" : "Failed"));

        // Test case 5
        int[] nums5 = {1, 1, 1, 1};
        int expected5 = 3;
        int result5 = solution.jump(nums5);
        System.out.println("Test case 5: " + (result5 == expected5 ? "Passed" : "Failed"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            return -1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
