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
// Related Topics 数组 字符串 回溯 矩阵 👍 1800 👎 0


package Top100Liked.leetcode.editor.cn;

public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();

        // Test case 1
        char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word1 = "ABCCED";
        boolean expected1 = true;
        testExist(solution, board1, word1, expected1);

        // Test case 2
        char[][] board2 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word2 = "SEE";
        boolean expected2 = true;
        testExist(solution, board2, word2, expected2);

        // Test case 3
        char[][] board3 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word3 = "ABCB";
        boolean expected3 = false;
        testExist(solution, board3, word3, expected3);

        // Add more test cases as needed
    }

    public static void testExist(Solution solution, char[][] board, String word, boolean expected) {
        boolean result = solution.exist(board, word);
        if (result == expected) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed. Expected " + expected + " but got " + result);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        private int m, n;

        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
            boolean[][] used = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfsSearch(board, 0, i, j, used, word)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfsSearch(char[][] board, int pos, int row, int col, boolean[][] used, String word) {
            if (pos == word.length() - 1) {
                return board[row][col] == word.charAt(pos);
            }
            if (board[row][col] == word.charAt(pos)) {
                used[row][col] = true;
                for (int[] direction : directions) {
                    int newX = row + direction[0];
                    int newY = col + direction[1];
                    if (inArea(newX, newY) && !used[newX][newY]) {
                        if (dfsSearch(board, pos + 1, newX, newY, used, word)) {
                            return true;
                        }
                    }
                }
                used[row][col] = false;
            }
            return false;

        }

        private boolean inArea(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}