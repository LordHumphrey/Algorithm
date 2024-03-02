// 给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
//
//
// 示例 1：
//
//
// 输入：s = "3[a]2[bc]"
// 输出："aaabcbc"
//
//
// 示例 2：
//
//
// 输入：s = "3[a2[c]]"
// 输出："accaccacc"
//
//
// 示例 3：
//
//
// 输入：s = "2[abc]3[cd]ef"
// 输出："abcabccdcdcdef"
//
//
// 示例 4：
//
//
// 输入：s = "abc3[cd]xyz"
// 输出："abccdcdcdxyz"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 30
//
// s 由小写英文字母、数字和方括号
// '[]' 组成
// s 保证是一个 有效 的输入。
// s 中所有整数的取值范围为
// [1, 300]
//
//
// Related Topics 栈 递归 字符串 👍 1692 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        String test1 = "3[a]2[bc]";
        String test2 = "3[a2[c]]";
        String test3 = "2[abc]3[cd]ef";
        String test4 = "abc3[cd]xyz";
        String test5 = "100[leetcode]";
        String test6 = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";

        //        System.out.println(solution.decodeString(test1)); // Expected output: "aaabcbc"
        //        System.out.println(solution.decodeString(test2)); // Expected output: "accaccacc"
        //        System.out.println(solution.decodeString(test3)); // Expected output: "abcabccdcdcdef"
        //        System.out.println(solution.decodeString(test4)); // Expected output: "abccdcdcdxyz"
        //        System.out.println(solution.decodeString(test5)); // Expected output: "abccdcdcdxyz"
        System.out.println(solution.decodeString(test6)); // Expected output: "abccdcdcdxyz"
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            char[] charArray = s.toCharArray();
            Deque<Object> stack = new ArrayDeque<>();
            int num = 0;
            for (char c : charArray) {
                if (Character.isDigit(c)) {
                    num = num * 10 + c - '0';
                } else if (c == '[') {
                    stack.push(num);
                    num = 0;
                } else if (c == ']') {
                    StringBuilder stringBuilder = new StringBuilder();
                    while (true) {
                        if (isNumeric((String) stack.peek())) {
                            String string = stringBuilder.reverse().toString();
                            String repeat =
                                    string.repeat(Math.max(0, Character.getNumericValue((Character) stack.pop())));
                            for (char c1 : repeat.toCharArray()) {
                                stack.push(c1);
                            }
                            break;
                        } else if (Character.isAlphabetic((Character) stack.peek())) {
                            stringBuilder.append(stack.pop());
                        }
                    }
                } else {
                    stack.push(c);
                }
            }
            Deque<Object> reversed = stack.reversed();
            return reversed.stream().map(String::valueOf).collect(Collectors.joining());
        }
    }

    public boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
