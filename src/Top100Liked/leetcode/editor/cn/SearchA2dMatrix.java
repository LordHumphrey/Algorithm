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
        testMatrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        testTarget = 11;
        result = solution.searchMatrix(testMatrix, testTarget);
        System.out.println("The target is in the matrix: " + result);
        testMatrix = new int[][] {
            {-8, -7, -5, -3, -3, -1, 1},
            {2, 2, 2, 3, 3, 5, 7},
            {8, 9, 11, 11, 13, 15, 17},
            {18, 18, 18, 20, 20, 20, 21},
            {23, 24, 26, 26, 26, 27, 27},
            {28, 29, 29, 30, 32, 32, 34}
        };
        testTarget = -5;
        result = solution.searchMatrix(testMatrix, testTarget);
        System.out.println("The target is in the matrix: " + result);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] mat, int t) {
            int row = mat.length, col = mat[0].length, mid = 0, left = 0, right = row - 1;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (t <= mat[mid][col - 1] && t >= mat[mid][0]) {
                    break;
                } else if (t > mat[mid][0]) {
                    left = mid + 1;
                } else if (t < mat[mid][0]) {
                    right = mid - 1;
                }
            }
            row = mid;
            left = 0;
            right = col - 1;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (t == mat[row][mid]) {
                    return true;
                } else if (t > mat[row][mid]) {
                    left = mid + 1;
                } else if (t < mat[row][mid]) {
                    right = mid - 1;
                }
            }
            return false;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        public boolean searchMatrix(int[][] mat, int t) {
            return false;
        }
    }
}
