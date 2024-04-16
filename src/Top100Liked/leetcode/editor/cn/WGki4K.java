// 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
//
//
//
// 示例 1：
//
//
// 输入：nums = [2,2,3,2]
// 输出：3
//
//
// 示例 2：
//
//
// 输入：nums = [0,1,0,1,0,1,100]
// 输出：100
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 10⁴
// -2³¹ <= nums[i] <= 2³¹ - 1
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
//
//
//
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
//
//
//
// 注意：本题与主站 137 题相同：https://leetcode-cn.com/problems/single-number-ii/
//
// Related Topics 位运算 数组 👍 152 👎 0

package Top100Liked.leetcode.editor.cn;

public class WGki4K {
    public static void main(String[] args) {
        Solution solution = new WGki4K().new Solution();

        // Test case 1
        int[] nums1 = {2, 2, 3, 2};
        int expected1 = 3;
        int result1 = solution.singleNumber(nums1);
        System.out.println("Test case 1: " + (expected1 == result1 ? "Passed" : "Failed"));

        // Test case 2
        int[] nums2 = {0, 1, 0, 1, 0, 1, 100};
        int expected2 = 100;
        int result2 = solution.singleNumber(nums2);
        System.out.println("Test case 2: " + (expected2 == result2 ? "Passed" : "Failed"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            int[] bitSum = new int[32];
            for (int num : nums) {
                for (int i = 0; i < 32; i++) {
                    bitSum[i] += (num >> (31 - i) & 1);
                }
            }
            for (int j : bitSum) {
                ans = (ans << 1) | j % 3;
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
