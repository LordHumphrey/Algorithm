// 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
//
//
//
// 示例 1：
//
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
// 输出: true
// 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
//
//
// 示例 2：
//
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
// 输出: true
// 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//      注意，你可以重复使用字典中的单词。
//
//
// 示例 3：
//
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
// 输出: false
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s 和 wordDict[i] 仅由小写英文字母组成
// wordDict 中的所有字符串 互不相同
//
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2451 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();

        // Test case 1
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        boolean expected1 = true;
        boolean result1 = solution.wordBreak(s1, wordDict1);
        System.out.println("Test case 1: " + (expected1 == result1 ? "Passed" : "Failed"));

        // Test case 2
        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        boolean expected2 = true;
        boolean result2 = solution.wordBreak(s2, wordDict2);
        System.out.println("Test case 2: " + (expected2 == result2 ? "Passed" : "Failed"));

        // Test case 3
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean expected3 = false;
        boolean result3 = solution.wordBreak(s3, wordDict3);
        System.out.println("Test case 3: " + (expected3 == result3 ? "Passed" : "Failed"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
