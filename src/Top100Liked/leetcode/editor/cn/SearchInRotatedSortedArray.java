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
// Related Topics 数组 二分查找 👍 2871 👎 0

package Top100Liked.leetcode.editor.cn;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        int[] nums = {5, 1, 3};
        int target = 1;
        int result = solution.search(nums, target);
        System.out.println(result);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int min = findMin(nums);
            if (target > nums[nums.length - 1]) {
                return findTarget(nums, -1, min, target);
            }
            return findTarget(nums, min - 1, nums.length, target);
        }

        private int findTarget(int[] nums, int left, int right, int target) {
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            return nums[right] == target ? right : -1;
        }

        public int findMin(int[] nums) {
            int n = nums.length;
            int left = -1, right = n - 1; // 开区间 (-1, n-1)
            while (left + 1 < right) { // 开区间不为空
                int mid = left + (right - left) / 2;
                if (nums[mid] < nums[n - 1]) right = mid; // 蓝色
                else left = mid; // 红色
            }
            return right;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
