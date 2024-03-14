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
// Related Topics 数组 回溯 👍 2038 👎 0

package codingInterviewsSpecial.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        NQueens.Solution solution = nQueens.new Solution();
        System.out.println(solution.solveNQueens(
                4)); // Expected output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        System.out.println(solution.solveNQueens(1)); // Expected output: [["Q"]]
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] arr = new char[n][n];
            for (char[] chars : arr) {
                Arrays.fill(chars, '.');
            }
            List<List<String>> res = new ArrayList<>();
            dfs(arr, 0, 0, n, res);
            return res;
        }

        private void dfs(char[][] arr, int row, int col, int n, List<List<String>> res) {
            if (row == n) {
                res.add(convertCharMatrixToNQueensFormat(arr));
                return;
            }
            for (int i = row; i < n; i++) {
                if (isValid(i, col, arr, n)) {
                    arr[i][col] = 'Q';
                    dfs(arr, row, col + 1, n, res);
                    arr[i][col] = '.';
                }
            }
        }

        private List<String> convertCharMatrixToNQueensFormat(char[][] res) {
            List<String> temp = new ArrayList<>();
            for (char[] re : res) {
                temp.add(new String(re));
            }
            return temp;
        }

        private boolean isValid(int row, int col, char[][] arr, int n) {
            for (int i = 0; i < n; i++) {
                if (arr[row][i] == 'Q') {
                    return false;
                }
                if (arr[i][col] == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (arr[i][j] == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (arr[i][j] == 'Q') {
                    return false;
                }
            }

            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
