// 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//
//
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
//
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
//
//
//
// 示例 1：
//
//
// 输入：text1 = "abcde", text2 = "ace"
// 输出：3
// 解释：最长公共子序列是 "ace" ，它的长度为 3 。
//
//
// 示例 2：
//
//
// 输入：text1 = "abc", text2 = "abc"
// 输出：3
// 解释：最长公共子序列是 "abc" ，它的长度为 3 。
//
//
// 示例 3：
//
//
// 输入：text1 = "abc", text2 = "def"
// 输出：0
// 解释：两个字符串没有公共子序列，返回 0 。
//
//
//
//
// 提示：
//
//
// 1 <= text1.length, text2.length <= 1000
// text1 和 text2 仅由小写英文字符组成。
//
//
// Related Topics 字符串 动态规划 👍 1533 👎 0

package Top100Liked.leetcode.editor.cn;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();

        // Test case 1
        String text1_1 = "abcde";
        String text2_1 = "ace";
        int expected1 = 3;
        int result1 = solution.longestCommonSubsequence(text1_1, text2_1);
        System.out.println("Test case 1: " + (expected1 == result1 ? "Passed" : "Failed"));

        // Test case 2
        String text1_2 = "abc";
        String text2_2 = "abc";
        int expected2 = 3;
        int result2 = solution.longestCommonSubsequence(text1_2, text2_2);
        System.out.println("Test case 2: " + (expected2 == result2 ? "Passed" : "Failed"));

        // Test case 3
        String text1_3 = "abc";
        String text2_3 = "def";
        int expected3 = 0;
        int result3 = solution.longestCommonSubsequence(text1_3, text2_3);
        System.out.println("Test case 3: " + (expected3 == result3 ? "Passed" : "Failed"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {

            return -1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
