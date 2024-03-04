// 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//
//
//
//
//
// 示例 1:
//
//
// 输入: numRows = 5
// 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
//
// 示例 2:
//
//
// 输入: numRows = 1
// 输出: [[1]]
//
//
//
//
// 提示:
//
//
// 1 <= numRows <= 30
//
//
// Related Topics 数组 动态规划 👍 1123 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        List<List<Integer>> result1 = solution.generate(5);
        List<List<Integer>> result2 = solution.generate(1);
        System.out.println("When numRows = 5, the result is: " + result1);
        System.out.println("When numRows = 1, the result is: " + result2);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            if (numRows == 0) {
                return ans;
            }
            List<Integer> path = new ArrayList<>();
            ans.add(new ArrayList<>());
            ans.getFirst().add(1);
            for (int i = 2; i <= numRows; i++) {
                List<Integer> curRow = new ArrayList<>();
                List<Integer> preRow = ans.get(i - 2);
                curRow.add(1);
                for (int i1 = 1; i1 < i - 1; i1++) {
                    curRow.add(preRow.get(i1) + preRow.get(i1 - 1));
                }
                curRow.add(1);
                ans.add(curRow);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
