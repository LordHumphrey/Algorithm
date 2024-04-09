// 给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//
//
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。
//
//
//
// 示例 1：
//
//
// 输入：nums = [2,0,2,1,1,0]
// 输出：[0,0,1,1,2,2]
//
//
// 示例 2：
//
//
// 输入：nums = [2,0,1]
// 输出：[0,1,2]
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 300
// nums[i] 为 0、1 或 2
//
//
//
//
// 进阶：
//
//
// 你能想出一个仅使用常数空间的一趟扫描算法吗？
//
//
// Related Topics 数组 双指针 排序 👍 1765 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();

        // Test case 1
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        int[] expected1 = {0, 0, 1, 1, 2, 2};
        solution.sortColors(nums1);
        System.out.println("Test case 1: " + (Arrays.equals(nums1, expected1) ? "Passed" : "Failed"));

        // Test case 2
        int[] nums2 = {2, 0, 1};
        int[] expected2 = {0, 1, 2};
        solution.sortColors(nums2);
        System.out.println("Test case 2: " + (Arrays.equals(nums2, expected2) ? "Passed" : "Failed"));

        // Test case 3
        int[] nums3 = {1, 2, 0};
        int[] expected3 = {0, 1, 2};
        solution.sortColors(nums3);
        System.out.println("Test case 3: " + (Arrays.equals(nums3, expected3) ? "Passed" : "Failed"));

        // Test case 4
        int[] nums4 = {2, 2, 1, 1, 0, 0};
        int[] expected4 = {0, 0, 1, 1, 2, 2};
        solution.sortColors(nums4);
        System.out.println("Test case 4: " + (Arrays.equals(nums4, expected4) ? "Passed" : "Failed"));

        // Test case 5
        int[] nums5 = {0};
        int[] expected5 = {0};
        solution.sortColors(nums5);
        System.out.println("Test case 5: " + (Arrays.equals(nums5, expected5) ? "Passed" : "Failed"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int length = nums.length;
            int left = 0, right = length - 1, i = 0;
            return;
        }

        private void swap(int i, int j, int[] nums) {
            if (i != j) {
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[i] ^ nums[j];
                nums[i] = nums[i] ^ nums[j];
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
