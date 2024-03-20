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
import java.util.Objects;

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
        grid = new int[][] {
            {2, 1, 1},
            {1, 1, 1},
            {0, 1, 2}
        };
        result = solution.orangesRotting(grid);
        System.out.println("Time required for all oranges to rot: " + result);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            Deque<int[]> queue = new ArrayDeque<>();
            int fresh = 0;
            for (int i = 0; i < row; i++) {
                for (int i1 = 0; i1 < col; i1++) {
                    if (grid[i][i1] == 1) {
                        fresh++;
                    } else if (grid[i][i1] == 2) {
                        queue.addLast(new int[] {i, i1});
                    }
                }
            }
            int[][] pos = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int ans = 0;
            while (!queue.isEmpty() && fresh > 0) {
                int size = queue.size();
                ans++;
                for (int i = 0; i < size; i++) {
                    int[] first = queue.pollFirst();
                    int r = Objects.requireNonNull(first)[0];
                    int c = Objects.requireNonNull(first)[1];
                    for (int[] po : pos) {
                        int rPos = po[0], cPos = po[1];
                        int rNew = rPos + r;
                        int cNew = cPos + c;
                        if (rNew < row && rNew >= 0 && cNew < col && cNew >= 0 && grid[rNew][cNew] == 1) {
                            grid[rNew][cNew] = 2;
                            queue.add(new int[] {rNew, cNew});
                            fresh--;
                        }
                    }
                }
            }

            return fresh == 0 ? ans : -1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
