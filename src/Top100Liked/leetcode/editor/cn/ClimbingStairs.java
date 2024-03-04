// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//
//
// 示例 1：
//
//
// 输入：n = 2
// 输出：2
// 解释：有两种方法可以爬到楼顶。
// 1. 1 阶 + 1 阶
// 2. 2 阶
//
// 示例 2：
//
//
// 输入：n = 3
// 输出：3
// 解释：有三种方法可以爬到楼顶。
// 1. 1 阶 + 1 阶 + 1 阶
// 2. 1 阶 + 2 阶
// 3. 2 阶 + 1 阶
//
//
//
//
// 提示：
//
//
// 1 <= n <= 45
//
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3455 👎 0

package Top100Liked.leetcode.editor.cn;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        //        int result1 = solution.climbStairs(2);
        int result2 = solution.climbStairs(3);
        //        System.out.println("When n = 2, the result is: " + result1);
        System.out.println("When n = 3, the result is: " + result2);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (0 == n) {
                return 0;
            } else if (1 == n) {
                return 1;
            } else if (2 == n) {
                return 2;
            }
            int[] ans = new int[n + 1];
            ans[0] = 0;
            ans[1] = 1;
            ans[2] = 2;
            for (int i = 3; i <= n; i++) {
                ans[i] = ans[i - 1] + ans[i - 2];
            }
            return ans[n];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
