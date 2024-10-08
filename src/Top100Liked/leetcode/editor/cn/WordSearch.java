//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
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
// Related Topics 数组 字符串 回溯 矩阵 👍 1884 👎 0


package Top100Liked.leetcode.editor.cn;

import java.util.Arrays;

public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();

        // Test case 1
        char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word1 = "ABCCED";
        boolean result1 = solution.exist(board1, word1);
        System.out.println("1-" + (result1 ? "Passed" : "Failed") + "-board: " + Arrays.deepToString(board1) + ", word: " + word1);

        // Test case 2
        char[][] board2 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word2 = "SEE";
        boolean result2 = solution.exist(board2, word2);
        System.out.println("2-" + (result2 ? "Passed" : "Failed") + "-board: " + Arrays.deepToString(board2) + ", word: " + word2);

        // Test case 3
        char[][] board3 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word3 = "ABCB";
        boolean result3 = solution.exist(board3, word3);
        System.out.println("3-" + (result3 ? "Passed" : "Failed") + "-board: " + Arrays.deepToString(board3) + ", word: " + word3);

        // Add more test cases as needed
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, i, j, 0, word, new boolean[board.length][board[0].length])) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int x, int y, int pos, String word, boolean[][] used) {
            return true;
        }

        private boolean inArea(char[][] board, int x, int y) {
            return 0 <= x && x < board.length && 0 <= y && y < board[0].length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}