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
// Related Topics 广度优先搜索 数组 矩阵 👍 814 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottingOranges {
    public static void main(String[] args) {
        Solution solution = new RottingOranges().new Solution();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int result = solution.orangesRotting(grid);
        System.out.println("Time required for all oranges to rot: " + result);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {
            int fresh = 0, row = grid.length, col = grid[0].length;
            Deque<int[]> deque = new ArrayDeque<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 2) {
                        deque.addLast(new int[] {i, j});
                    } else if (grid[i][j] == 1) {
                        fresh++;
                    }
                }
            }
            int round = 0;
            while (!deque.isEmpty() && fresh > 0) {
                round++;
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    int[] point = deque.pollFirst();
                    int r = point[0], c = point[1];
                    if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                        grid[r - 1][c] = 2;
                        fresh--;
                        deque.addLast(new int[] {r - 1, c});
                    }
                    if (r + 1 < row && grid[r + 1][c] == 1) {
                        grid[r + 1][c] = 2;
                        fresh--;
                        deque.addLast(new int[] {r + 1, c});
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                        grid[r][c - 1] = 2;
                        fresh--;
                        deque.addLast(new int[] {r, c - 1});
                    }
                    if (c + 1 < col && grid[r][c + 1] == 1) {
                        grid[r][c + 1] = 2;
                        fresh--;
                        deque.addLast(new int[] {r, c + 1});
                    }
                }
            }
            return fresh == 0 ? round : -1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
