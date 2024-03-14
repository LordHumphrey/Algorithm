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
// Related Topics 数组 二分查找 👍 2265 👎 0

package Top100Liked.leetcode.editor.cn;

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        Solution solution = searchInsertPosition.new Solution();
        int[] testNums = {1, 3, 5, 6};
        int testTarget = 5;
        int result = solution.searchInsert(testNums, testTarget);
        System.out.println("The target would be inserted at index: " + result);
        testNums = new int[] {1, 3, 5, 6};
        testTarget = 2;
        result = solution.searchInsert(testNums, testTarget);
        System.out.println("The target would be inserted at index: " + result);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            return 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
