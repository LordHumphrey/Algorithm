//给你一个非负整数数组 nums 和一个整数 target 。
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 2017 👎 0


package Top100Liked.leetcode.editor.cn;

public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();

        // Test case 1
        int[] nums1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        int expected1 = 5;
        int result1 = solution.findTargetSumWays(nums1, target1);
        System.out.println("1-" + (expected1 == result1 ? "通过" : "未通过") + "-nums: [1, 1, 1, 1, 1], target: 3");

        // Test case 2
        int[] nums2 = {1};
        int target2 = 1;
        int expected2 = 1;
        int result2 = solution.findTargetSumWays(nums2, target2);
        System.out.println("2-" + (expected2 == result2 ? "通过" : "未通过") + "-nums: [1], target: 1");

        // Test case 3
        int[] nums3 = {1, 2, 1};
        int target3 = 2;
        int expected3 = 2;
        int result3 = solution.findTargetSumWays(nums3, target3);
        System.out.println("3-" + (expected3 == result3 ? "通过" : "未通过") + "-nums: [1, 2, 1], target: 2");

        // Test case 4
        int[] nums4 = {1, 2, 7, 9, 981};
        int target4 = 1000000000;
        int expected4 = 0;
        int result4 = solution.findTargetSumWays(nums4, target4);
        System.out.println("4-" + (expected4 == result4 ? "通过" : "未通过") + "-nums: [1, 2, 7, 9, 981], target: 1000000000");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}