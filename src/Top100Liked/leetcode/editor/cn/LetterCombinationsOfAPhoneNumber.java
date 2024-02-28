// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
// 输入：digits = "23"
// 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
// 输入：digits = ""
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：digits = "2"
// 输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
//
// Related Topics 哈希表 字符串 回溯 👍 2762 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber instance = new LetterCombinationsOfAPhoneNumber();
        Solution solution = instance.new Solution();
        List<String> result = solution.letterCombinations("23");
        System.out.println(result);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, String> phoneMap;

        public List<String> letterCombinations(String digits) {
            phoneMap = new HashMap<Character, String>(8) {
                {
                    put('2', "abc");
                    put('3', "def");
                    put('4', "ghi");
                    put('5', "jkl");
                    put('6', "mno");
                    put('7', "pqrs");
                    put('8', "tuv");
                    put('9', "wxyz");
                }
            };
            List<String> res = new ArrayList<>();
            if (digits.isEmpty()) {
                return res;
            }
            dfs(digits, 0, new StringBuilder(), res);
            return res;
        }

        private void dfs(String digits, int start, StringBuilder sb, List<String> res) {
            if (start == digits.length()) {
                res.add(sb.toString());
                return;
            }
            char c = digits.charAt(start);
            String s = phoneMap.get(c);
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                dfs(digits, start + 1, sb, res);
                sb.deleteCharAt(start);
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
