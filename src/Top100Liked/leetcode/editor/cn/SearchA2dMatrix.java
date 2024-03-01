// 给你一个满足下述两条属性的 m x n 整数矩阵：
//
//
// 每行中的整数从左到右按非严格递增顺序排列。
// 每行的第一个整数大于前一行的最后一个整数。
//
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
// 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// 输出：true
//
//
// 示例 2：
//
//
// 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// 输出：false
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -10⁴ <= matrix[i][j], target <= 10⁴
//
//
// Related Topics 数组 二分查找 矩阵 👍 901 👎 0

package Top100Liked.leetcode.editor.cn;

public class SearchA2dMatrix {
    public static void main(String[] args) {
        SearchA2dMatrix searchA2dMatrix = new SearchA2dMatrix();
        Solution solution = searchA2dMatrix.new Solution();
        int[][] testMatrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int testTarget = 3;
        boolean result = solution.searchMatrix(testMatrix, testTarget);
        System.out.println("The target is in the matrix: " + result);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] mat, int t) {
            int m = mat.length, n = mat[0].length;

            // 第一次二分：定位到所在行（从上往下，找到最后一个满足 mat[x]][0] <= t 的行号）
            int l = 0, r = m - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (mat[mid][0] <= t) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }

            int row = r;
            if (mat[row][0] == t) return true;
            if (mat[row][0] > t) return false;

            // 第二次二分：从所在行中定位到列（从左到右，找到最后一个满足 mat[row][x] <= t 的列号）
            l = 0;
            r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (mat[row][mid] <= t) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int col = r;

            return mat[row][col] == t;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        public boolean searchMatrix(int[][] mat, int t) {
            int m = mat.length, n = mat[0].length;
            int l = 0, r = m * n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (mat[mid / n][mid % n] <= t) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return mat[r / n][r % n] == t;
        }
    }
}
