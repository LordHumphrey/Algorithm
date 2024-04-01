// 在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一：
//
//
// 值 0 代表空单元格；
// 值 1 代表新鲜橘子；
// 值 2 代表腐烂的橘子。
//
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
//
//
//
// 示例 1：
//
//
//
//
// 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
// 输出：4
//
//
// 示例 2：
//
//
// 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
// 输出：-1
// 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
//
//
// 示例 3：
//
//
// 输入：grid = [[0,2]]
// 输出：0
// 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] 仅为 0、1 或 2
//
//
// Related Topics 广度优先搜索 数组 矩阵 👍 830 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottingOranges {
    public static void main(String[] args) {
        Solution solution = new RottingOranges().new Solution();

        // Test case 1
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int expected1 = 4;
        int result1 = solution.orangesRotting(grid1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test case 2
        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int expected2 = -1;
        int result2 = solution.orangesRotting(grid2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test case 3
        int[][] grid3 = {{0, 2}};
        int expected3 = 0;
        int result3 = solution.orangesRotting(grid3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {
            int row = grid.length, col = grid[0].length;
            Deque<int[]> queue = new ArrayDeque<>();
            int fresh = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 2) {
                        queue.add(new int[] {i, j});
                    } else if (grid[i][j] == 1) {
                        fresh++;
                    }
                }
            }
            int cnt = 0;
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // up, down, right, left
            while (!queue.isEmpty() && fresh > 0) {
                int size = queue.size();
                cnt++;
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.pollFirst();
                    int rowNew = poll[0];
                    int colNew = poll[1];
                    for (int[] direction : directions) {
                        int newRow = rowNew + direction[0];
                        int newCol = colNew + direction[1];
                        if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && grid[newRow][newCol] == 1) {
                            queue.add(new int[] {newRow, newCol});
                            grid[newRow][newCol] = 2; // mark as rotten
                            fresh--;
                        }
                    }
                }
            }
            return fresh == 0 ? cnt : -1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
