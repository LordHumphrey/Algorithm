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
// Related Topics 数组 回溯 👍 2033 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        Solution solution = nQueens.new Solution();
        int testN = 4;
        List<List<String>> result = solution.solveNQueens(testN);
        for (List<String> list : result) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> solveNQueens(int n) {
            char[][] arr = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(arr[i], '.');
            }
            List<List<String>> res = new ArrayList<>();
            dfs(arr, 0, 0, res);
            return res;
        }

        private void dfs(char[][] arr, int row, int col, List<List<String>> ans) {
            if (arr.length == row) {
                ans.add(convertCharMatrixToNQueensFormat(arr));
                return;
            }
            for (int i = col; i < arr.length; i++) {
                if (notConflict(arr, row, i)) {
                    arr[row][i] = 'Q';
                    dfs(arr, row + 1, col, ans);
                    arr[row][i] = '.';
                }
            }
        }

        private List<String> convertCharMatrixToNQueensFormat(char[][] res) {
            List<String> result = new ArrayList<>();
            for (char[] row : res) {
                result.add(new String(row));
            }
            return result;
        }

        private boolean notConflict(char[][] arr, int row, int col) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][col] == 'Q') {
                    return false;
                }
                if (arr[row][i] == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (arr[i][j] == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
                if (arr[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }

        private boolean isValidPos(int row, int col, int n) {
            return 0 <= row && row < n && 0 <= col && col < n;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
