// 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 回文串 是正着读和反着读都一样的字符串。
//
//
//
// 示例 1：
//
//
// 输入：s = "aab"
// 输出：[["a","a","b"],["aa","b"]]
//
//
// 示例 2：
//
//
// 输入：s = "a"
// 输出：[["a"]]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 16
// s 仅由小写英文字母组成
//
//
// Related Topics 字符串 动态规划 回溯 👍 1735 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {

        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        Solution solution = new PalindromePartitioning().new Solution();
        String testString = "aab";
        List<List<String>> result = solution.partition(testString);
        System.out.println(result);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            dfs(ans, 0, new ArrayDeque<>(), s);
            return ans;
        }

        private void dfs(List<List<String>> ans, int start, Deque<String> path, String s) {
            if (start == s.length()) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(start, i, s)) {
                    path.addLast(s.substring(start, i + 1));
                    dfs(ans, i + 1, path, s);
                    path.removeLast();
                }
            }
        }

        private boolean isPalindrome(int left, int right, String s) {
            while (left < right) {
                if (s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
