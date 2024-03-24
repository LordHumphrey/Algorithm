// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 每个右括号都有一个对应的相同类型的左括号。
//
//
//
//
// 示例 1：
//
//
// 输入：s = "()"
// 输出：true
//
//
// 示例 2：
//
//
// 输入：s = "()[]{}"
// 输出：true
//
//
// 示例 3：
//
//
// 输入：s = "(]"
// 输出：false
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 仅由括号 '()[]{}' 组成
//
//
// Related Topics 栈 字符串 👍 4396 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        assertValid(solution.isValid("()"), true); // 输出应为 true
        assertValid(solution.isValid("()[]{}"), true); // 输出应为 true
        assertValid(solution.isValid("(]"), false); // 输出应为 false
        assertValid(solution.isValid("([)]"), false); // 输出应为 false
        assertValid(solution.isValid("{[]}"), true); // 输出应为 true
        assertValid(solution.isValid(""), true); // 输出应为 true
        assertValid(solution.isValid("["), false); // 输出应为 false
        assertValid(solution.isValid("(){}}{"), false); // 输出应为 false
    }

    public static void assertValid(boolean actual, boolean expected) {
        if (actual == expected) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed. Expected " + expected + " but got " + actual);
        }
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if (c == ')' && top != '(') {
                        return false;
                    } else if (c == '}' && top != '{') {
                        return false;
                    } else if (c == ']' && top != '[') {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
