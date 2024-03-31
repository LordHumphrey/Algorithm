// 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
// 输入：n = 3
// 输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
// 输入：n = 1
// 输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
//
// Related Topics 字符串 动态规划 回溯 👍 3541 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();

        // Test case 1
        int n1 = 3;
        List<String> expected1 = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        List<String> result1 = solution.generateParenthesis(n1);
        System.out.println("Test case 1: " + (expected1.equals(result1) ? "Passed" : "Failed"));

        // Test case 2
        int n2 = 1;
        List<String> expected2 = Arrays.asList("()");
        List<String> result2 = solution.generateParenthesis(n2);
        System.out.println("Test case 2: " + (expected2.equals(result2) ? "Passed" : "Failed"));
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            ArrayList<String> arrayList = new ArrayList<>();
            dfs(n, new StringBuilder(), 0, 0, arrayList);
            return arrayList;
        }

        private void dfs(int n, StringBuilder sb, int left, int right, List<String> ans) {
            if (sb.length() == 2 * n) {
                ans.add(sb.toString());
            }
            if (left < n) {
                sb.append("(");
                dfs(n, sb, left + 1, right, ans);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (left > right) {
                sb.append(")");
                dfs(n, sb, left, right + 1, ans);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
