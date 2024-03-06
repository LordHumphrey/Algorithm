// 给你一个字符串 s，找到 s 中最长的回文子串。
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
//
//
//
// 示例 1：
//
//
// 输入：s = "babad"
// 输出："bab"
// 解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
// 输入：s = "cbbd"
// 输出："bb"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母组成
//
//
// Related Topics 字符串 动态规划 👍 7092 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad")); // 输出："bab"
        System.out.println(solution.longestPalindrome("cbbd")); // 输出："bb"
        System.out.println(solution.longestPalindrome("a")); // 输出："a"
        System.out.println(solution.longestPalindrome("ac")); // 输出："a"
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();
            int[] dp = new int[length];
            Arrays.fill(dp, 1);
            for (int i = 1; i < length; i++) {
                for (int j = 0; j <= i; j++) {
                    String substring = s.substring(j, i);
                    //                    if (validPalindromic(substring)) {
                    dp[i] = Math.max(dp[i], dp[i]);
                    //                    }
                }
            }
            return "";
        }

        public String longestPalindrome1(String s) {

            int res = 1, len = s.length(), start = 0;
            for (int i = 0; i < len; i++) {
                for (int i1 = i; i1 < len; i1++) {
                    if (i1 - i + 1 > res && validPalindromic(s, i, i1)) {
                        res = i1 - i + 1;
                        start = i;
                    }
                }
            }
            return s.substring(start, start + res);
        }

        private boolean validPalindromic(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
