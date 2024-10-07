// 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
//
// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
//
// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,3,4,2,2]
// 输出：2
//
//
// 示例 2：
//
//
// 输入：nums = [3,1,3,4,2]
// 输出：3
//
//
// 示例 3 :
//
//
// 输入：nums = [3,3,3,3,3]
// 输出：3
//
//
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁵
// nums.length == n + 1
// 1 <= nums[i] <= n
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
//
//
//
//
// 进阶：
//
//
// 如何证明 nums 中至少存在一个重复的数字?
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
//
//
// Related Topics 位运算 数组 双指针 二分查找 👍 2376 👎 0

package Top100Liked.leetcode.editor.cn;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();

        // Test case 1
        int[] nums1 = {1, 3, 4, 2, 2};
        int expected1 = 2;
        int result1 = solution.findDuplicate(nums1);
        System.out.println("Test case 1: " + (expected1 == result1 ? "Passed" : "Failed"));

        // Test case 2
        int[] nums2 = {3, 1, 3, 4, 2};
        int expected2 = 3;
        int result2 = solution.findDuplicate(nums2);
        System.out.println("Test case 2: " + (expected2 == result2 ? "Passed" : "Failed"));

        // Test case 3
        int[] nums3 = {3, 3, 3, 3, 3};
        int expected3 = 3;
        int result3 = solution.findDuplicate(nums3);
        System.out.println("Test case 3: " + (expected3 == result3 ? "Passed" : "Failed"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {
            return 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
