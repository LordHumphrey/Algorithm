// 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//
//
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
//
//
// 示例 1：
//
//
// 输入：n = 4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释：如上图所示，4 皇后问题存在两个不同的解法。
//
//
// 示例 2：
//
//
// 输入：n = 1
// 输出：[["Q"]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 9
//
//
// Related Topics 数组 回溯 👍 2052 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();

        // Test case 1: n = 1, there is 1 solution
        List<List<String>> result1 = solution.solveNQueens(1);
        System.out.println("Test case 1: n = 1, expected 1 solution, got " + result1.size() + " solution(s).");
        for (List<String> solution1 : result1) {
            System.out.println(solution1);
        }

        // Test case 2: n = 4, there are 2 solutions
        List<List<String>> result2 = solution.solveNQueens(4);
        System.out.println("Test case 2: n = 4, expected 2 solutions, got " + result2.size() + " solution(s).");
        for (List<String> solution2 : result2) {
            System.out.println(solution2);
        }

        // Test case 3: n = 0, there are 0 solutions
        List<List<String>> result3 = solution.solveNQueens(0);
        System.out.println("Test case 3: n = 0, expected 0 solutions, got " + result3.size() + " solution(s).");

        // Test case 4: n = 9, there are 352 solutions
        List<List<String>> result4 = solution.solveNQueens(9);
        System.out.println("Test case 4: n = 9, expected 352 solutions, got " + result4.size() + " solution(s).");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] grid = new char[n][n];
            for (char[] chars : grid) {
                Arrays.fill(chars, '.');
            }
            List<List<String>> res = new ArrayList<>();
            dfs(0, n, grid, res);
            return res;
        }

        private void dfs(int row, int n, char[][] grid, List<List<String>> res) {
            if (row == n) {
                List<String> rowRes = new ArrayList<>();
                for (char[] chars : grid) {
                    rowRes.add(new String(chars));
                }
                res.add(rowRes);
                return;
            }
            for (int i = 0; i < n; i++) {
                if (validQueens(row, i, n, grid)) {
                    grid[row][i] = 'Q';
                    dfs(row + 1, n, grid, res);
                    grid[row][i] = '.';
                }
            }
        }

        private boolean validQueens(int row, int col, int n, char[][] grid) {
            for (int i = 0; i < row; i++) {
                if (grid[i][col] == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (grid[i][j] == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (grid[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
