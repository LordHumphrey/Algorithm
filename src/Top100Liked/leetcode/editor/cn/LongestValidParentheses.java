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
// Related Topics 栈 字符串 动态规划 👍 2457 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();

        String s = "(()";
        int result = solution.longestValidParentheses(s);
        System.out.println(result); // Expected output: 2

        s = ")()())";
        result = solution.longestValidParentheses(s);
        System.out.println(result); // Expected output: 4

        s = "";
        result = solution.longestValidParentheses(s);
        System.out.println(result); // Expected output: 0
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);
            char[] charArray = s.toCharArray();
            if (charArray.length == 0) {
                return 0;
            }
            int res = 0;
            for (int i = 0; i < charArray.length; i++) {
                int temp = 0;
                if (charArray[i] == ')') {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        temp = i - stack.peek();
                        res = Math.max(res, temp);
                    } else {
                        stack.push(i);
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
