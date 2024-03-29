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
// Related Topics 数组 二分查找 矩阵 👍 907 👎 0

package codingInterviewsSpecial.leetcode.editor.cn;

public class SearchA2dMatrix {
    public static void main(String[] args) {
        SearchA2dMatrix searchA2dMatrix = new SearchA2dMatrix();
        Solution solution = searchA2dMatrix.new Solution();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println(result); // --> 返回 true
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length - 1, col = matrix[0].length - 1;
            int left = 0, right = row - 1, mid = 0;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (target >= matrix[mid][0] && matrix[mid][col] >= target) {
                    row = mid;
                    break;
                } else if (target > matrix[mid][0]) {
                    left = mid + 1;
                } else if (target < matrix[mid][0]) {
                    right = mid - 1;
                }
            }
            left = 0;
            right = col;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (target == matrix[row][mid]) {
                    return true;
                } else if (target > matrix[row][mid]) {
                    left = mid + 1;
                } else if (target < matrix[row][mid]) {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
