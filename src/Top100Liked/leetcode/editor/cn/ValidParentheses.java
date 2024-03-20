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
// Related Topics 栈 字符串 👍 4355 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        String test1 = "()";
        String test2 = "()[]{}";
        String test3 = "(]";
        System.out.println("Test case 1: " + test1 + ", result: " + solution.isValid(test1));
        System.out.println("Test case 2: " + test2 + ", result: " + solution.isValid(test2));
        System.out.println("Test case 3: " + test3 + ", result: " + solution.isValid(test3));
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            char[] charArray = s.toCharArray();
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                } else if (charArray[i] == '(') {
                    stack.push('(');
                } else if (charArray[i] == '{') {
                    stack.push('{');
                } else if (charArray[i] == '}') {
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                } else if (charArray[i] == '[') {
                    stack.push('[');
                } else if (charArray[i] == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
            return stack.isEmpty();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
