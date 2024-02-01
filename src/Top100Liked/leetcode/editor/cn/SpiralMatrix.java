//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1592 👎 0


package Top100Liked.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int len = matrix.length;
            if (0 == len) {
                return List.of();
            }
            List<Integer> res = new ArrayList<>();
            int up = 0, right = matrix[0].length - 1, left = 0, down = matrix.length - 1;
            while (true) {
                for (int i = left; i <= right; i++) {
                    int[] arr = matrix[up];
                    res.add(arr[i]);
                }
                if (++up > down) {
                    break;
                }
                for (int i = up; i <= down; i++) {
                    int[] arr = matrix[i];
                    res.add(arr[right]);
                }
                if (--right < left) {
                    break;
                }
                for (int i = right; i >= left; i--) {
                    int[] arr = matrix[down];
                    res.add(arr[i]);
                }
                if (--down < up) {
                    break;
                }
                for (int i = down; i >= up; i--) {
                    int[] arr = matrix[i];
                    res.add(arr[left]);
                }
                if (++left > right) {
                    break;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}