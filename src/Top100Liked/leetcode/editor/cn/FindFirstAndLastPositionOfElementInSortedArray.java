// 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
//
//
//
// 示例 1：
//
//
// 输入：nums = [5,7,7,8,8,10], target = 8
// 输出：[3,4]
//
// 示例 2：
//
//
// 输入：nums = [5,7,7,8,8,10], target = 6
// 输出：[-1,-1]
//
// 示例 3：
//
//
// 输入：nums = [], target = 0
// 输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// nums 是一个非递减数组
// -10⁹ <= target <= 10⁹
//
//
// Related Topics 数组 二分查找 👍 2632 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int start = lowerBound(nums, target); // 选择其中一种写法即可
            if (start == nums.length || nums[start] != target) {
                return new int[] {-1, -1};
            }
            // 如果 start 存在，那么 end 必定存在
            int end = lowerBound(nums, target + 1) - 1;
            return new int[] {start, end};
        }

        // 闭区间写法
        private int lowerBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1; // 闭区间 [left, right]
            while (left <= right) { // 区间不为空
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1; // 范围缩小到 [mid+1, right]
                } else {
                    right = mid - 1; // 范围缩小到 [left, mid-1]
                }
            }
            return left;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}
