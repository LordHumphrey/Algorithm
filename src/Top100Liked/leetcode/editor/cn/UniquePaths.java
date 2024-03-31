// 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
// 问总共有多少条不同的路径？
//
//
//
// 示例 1：
//
//
// 输入：m = 3, n = 7
// 输出：28
//
// 示例 2：
//
//
// 输入：m = 3, n = 2
// 输出：3
// 解释：
// 从左上角开始，总共有 3 条路径可以到达右下角。
// 1. 向右 -> 向下 -> 向下
// 2. 向下 -> 向下 -> 向右
// 3. 向下 -> 向右 -> 向下
//
//
// 示例 3：
//
//
// 输入：m = 7, n = 3
// 输出：28
//
//
// 示例 4：
//
//
// 输入：m = 3, n = 3
// 输出：6
//
//
//
// 提示：
//
//
// 1 <= m, n <= 100
// 题目数据保证答案小于等于 2 * 10⁹
//
//
// Related Topics 数学 动态规划 组合数学 👍 2008 👎 0

package Top100Liked.leetcode.editor.cn;

public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();

        // Test case 1
        int m1 = 3, n1 = 7;
        int expected1 = 28;
        int result1 = solution.uniquePaths(m1, n1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test case 2
        int m2 = 3, n2 = 2;
        int expected2 = 3;
        int result2 = solution.uniquePaths(m2, n2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test case 3
        int m3 = 7, n3 = 3;
        int expected3 = 28;
        int result3 = solution.uniquePaths(m3, n3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));

        // Test case 4
        int m4 = 3, n4 = 3;
        int expected4 = 6;
        int result4 = solution.uniquePaths(m4, n4);
        System.out.println("Test case 4: " + (result4 == expected4 ? "Passed" : "Failed"));
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int i1 = 1; i1 < n; i1++) {
                    dp[i][i1] = dp[i - 1][i1] + dp[i][i1 - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
