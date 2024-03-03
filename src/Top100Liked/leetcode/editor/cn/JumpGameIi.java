// 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
//
//
// 0 <= j <= nums[i]
// i + j < n
//
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
//
//
//
// 示例 1:
//
//
// 输入: nums = [2,3,1,1,4]
// 输出: 2
// 解释: 跳到最后一个位置的最小跳跃数是 2。
//      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 示例 2:
//
//
// 输入: nums = [2,3,0,1,4]
// 输出: 2
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁴
// 0 <= nums[i] <= 1000
// 题目保证可以到达 nums[n-1]
//
//
// Related Topics 贪心 数组 动态规划 👍 2454 👎 0

package Top100Liked.leetcode.editor.cn;

public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        int[] nums = {2, 3, 1, 1, 4};
        int expected = 2;
        int result = solution.jump(nums);
        System.out.println(result == expected); // 输出 true 或 false

        nums = new int[] {2, 3, 0, 1, 4};
        expected = 2;
        result = solution.jump(nums);
        System.out.println(result == expected); // 输出 true 或 false
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int len = nums.length, cnt = 0, maxPos = 0, end = 0;
            for (int i = 0; i < len - 1; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
                if (i == end) {
                    end = maxPos;
                    cnt++;
                }
            }
            return cnt;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
