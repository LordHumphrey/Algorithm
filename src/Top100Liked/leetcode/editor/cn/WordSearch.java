// 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例 1：
//
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
// 输出：true
//
//
// 示例 2：
//
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
// 输出：true
//
//
// 示例 3：
//
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
// 输出：false
//
//
//
//
// 提示：
//
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board 和 word 仅由大小写英文字母组成
//
//
//
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
//
// Related Topics 数组 字符串 回溯 矩阵 👍 1776 👎 0

package Top100Liked.leetcode.editor.cn;

public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean result = solution.exist(board, word);
        System.out.println(result);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int[][] DIRECTION = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        private int totalRow;
        private int totalCol;

        public boolean exist(char[][] board, String word) {
            totalRow = board.length;
            totalCol = board[0].length;
            for (int i = 0; i < board.length; i++) {
                for (int i1 = 0; i1 < board[0].length; i1++) {
                    if (dfs(board, word, i, i1, 0, new boolean[board.length][board[0].length])) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int row, int col, int wordPos, boolean[][] used) {
            if (board[row][col] != word.charAt(wordPos)) {
                return false;
            }
            if (wordPos == word.length() - 1) {
                return true;
            }

            used[row][col] = true;
            for (int[] ints : DIRECTION) {
                int tempRow = row + ints[0], tempCol = col + ints[1];
                if (isValidIndex(tempRow, tempCol)
                        && !used[tempRow][tempCol]
                        && board[tempRow][tempCol] == word.charAt(wordPos + 1)) {
                    if (dfs(board, word, tempRow, tempCol, wordPos + 1, used)) {
                        return true;
                    }
                }
            }
            used[row][col] = false;
            return false;
        }

        private boolean isValidIndex(int row, int col) {
            return row >= 0 && col >= 0 && row < totalRow && col < totalCol;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
