// 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
//
//
//
//
// 示例 1：
//
//
//
//
// 输入：s = "(()"
// 输出：2
// 解释：最长有效括号子串是 "()"
//
//
// 示例 2：
//
//
// 输入：s = ")()())"
// 输出：4
// 解释：最长有效括号子串是 "()()"
//
//
// 示例 3：
//
//
// 输入：s = ""
// 输出：0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 3 * 10⁴
// s[i] 为 '(' 或 ')'
//
//
// Related Topics 栈 字符串 动态规划 👍 2472 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();

        // Test case 1
        String s1 = "(()";
        int expected1 = 2;
        int result1 = solution.longestValidParentheses(s1);
        System.out.println("Test case 1: " + (expected1 == result1 ? "Passed" : "Failed"));

        // Test case 2
        String s2 = ")()())";
        int expected2 = 4;
        int result2 = solution.longestValidParentheses(s2);
        System.out.println("Test case 2: " + (expected2 == result2 ? "Passed" : "Failed"));

        // Test case 3
        String s3 = "";
        int expected3 = 0;
        int result3 = solution.longestValidParentheses(s3);
        System.out.println("Test case 3: " + (expected3 == result3 ? "Passed" : "Failed"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);
            int res = 0;
            for (int i = 0; i < s.toCharArray().length; i++) {
                if (s.charAt(i) == ')') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        int k = i - stack.peek();
                        res = Math.max(k, res);
                    }
                } else {
                    stack.push(i);
                }
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
