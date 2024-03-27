// 整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
// k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
// ,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
//
//
//
// 示例 1：
//
//
// 输入：nums = [4,5,6,7,0,1,2], target = 0
// 输出：4
//
//
// 示例 2：
//
//
// 输入：nums = [4,5,6,7,0,1,2], target = 3
// 输出：-1
//
// 示例 3：
//
//
// 输入：nums = [1], target = 0
// 输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// -10⁴ <= nums[i] <= 10⁴
// nums 中的每个值都 独一无二
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转
// -10⁴ <= target <= 10⁴
//
//
// Related Topics 数组 二分查找 👍 2899 👎 0

package Top100Liked.leetcode.editor.cn;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();

        // Test case 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        int expected1 = 4;
        int result1 = solution.search(nums1, target1);
        System.out.println("Test case 1: " + (expected1 == result1 ? "Passed" : "Failed"));

        // Test case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        int expected2 = -1;
        int result2 = solution.search(nums2, target2);
        System.out.println("Test case 2: " + (expected2 == result2 ? "Passed" : "Failed"));

        // Test case 3
        int[] nums3 = {1};
        int target3 = 0;
        int expected3 = -1;
        int result3 = solution.search(nums3, target3);
        System.out.println("Test case 3: " + (expected3 == result3 ? "Passed" : "Failed"));
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int i = nums.length - 1;
            int min = searchMin(nums, target, 0, i);
            if (target == nums[min]) {
                return min;
            } else if (target > nums[i]) {
                return searchTarget(nums, target, 0, min);
            } else {
                return searchTarget(nums, target, min, i);
            }
        }

        private int searchTarget(int[] nums, int target, int left, int right) {
            int mid = left + (right - left) / 2;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    return mid;
                }
            }
            return -1;
        }

        private int searchMin(int[] nums, int target, int left, int right) {
            int mid = left + (right - left) / 2;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    break;
                }
            }
            return right;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
