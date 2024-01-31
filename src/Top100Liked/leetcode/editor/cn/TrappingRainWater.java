// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
// 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
// 输出：6
// 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
// 输入：height = [4,2,0,3,2,5]
// 输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 1 <= n <= 2 * 10⁴
// 0 <= height[i] <= 10⁵
//
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4988 👎 0

package Top100Liked.leetcode.editor.cn;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        System.out.println(solution.trap(new int[] {4, 2, 0, 3, 2, 5}));
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int length = height.length;
            if (length == 0) {
                return 0;
            }
            int[] leftMax = new int[length], rightMax = new int[length];
            leftMax[0] = height[0];
            for (int i = 1; i < length; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
            rightMax[length - 1] = height[length - 1];
            for (int i = length - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
            int result = 0;
            for (int i = 0; i < length; i++) {
                result += Math.min(leftMax[i], rightMax[i]) - height[i];
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
