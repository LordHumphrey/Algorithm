// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 请必须使用时间复杂度为 O(log n) 的算法。
//
//
//
// 示例 1:
//
//
// 输入: nums = [1,3,5,6], target = 5
// 输出: 2
//
//
// 示例 2:
//
//
// 输入: nums = [1,3,5,6], target = 2
// 输出: 1
//
//
// 示例 3:
//
//
// 输入: nums = [1,3,5,6], target = 7
// 输出: 4
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 为 无重复元素 的 升序 排列数组
// -10⁴ <= target <= 10⁴
//
//
// Related Topics 数组 二分查找 👍 2282 👎 0

package Top100Liked.leetcode.editor.cn;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();

        // Test case 1
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        int expected1 = 2;
        int result1 = solution.searchInsert(nums1, target1);
        System.out.println("Test case 1: " + (expected1 == result1 ? "Passed" : "Failed"));

        // Test case 2
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        int expected2 = 1;
        int result2 = solution.searchInsert(nums2, target2);
        System.out.println("Test case 2: " + (expected2 == result2 ? "Passed" : "Failed"));

        // Test case 3
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        int expected3 = 4;
        int result3 = solution.searchInsert(nums3, target3);
        System.out.println("Test case 3: " + (expected3 == result3 ? "Passed" : "Failed"));

        // Test case 4
        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        int expected4 = 0;
        int result4 = solution.searchInsert(nums4, target4);
        System.out.println("Test case 4: " + (expected4 == result4 ? "Passed" : "Failed"));
        int[] nums5 = {1, 3, 5, 6};
        int target5 = 2;
        int expected5 = 1;
        int result5 = solution.searchInsert(nums5, target5);
        System.out.println("New test case: " + (expected5 == result5 ? "Passed" : "Failed"));
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1, mid = 0;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
