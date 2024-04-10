// 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
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
// Related Topics 字符串 动态规划 回溯 👍 1761 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.*;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();

        // Test case 1
        String s1 = "aab";
        List<List<String>> expected1 = new ArrayList<>();
        expected1.add(Arrays.asList("a", "a", "b"));
        expected1.add(Arrays.asList("aa", "b"));
        List<List<String>> result1 = solution.partition(s1);
        System.out.println("Test case 1: " + (result1.equals(expected1) ? "Passed" : "Failed"));

        // Test case 2
        String s2 = "a";
        List<List<String>> expected2 = new ArrayList<>();
        expected2.add(Arrays.asList("a"));
        List<List<String>> result2 = solution.partition(s2);
        System.out.println("Test case 2: " + (result2.equals(expected2) ? "Passed" : "Failed"));

        // Test case 3
        String s3 = "abcba";
        List<List<String>> expected3 = new ArrayList<>();
        expected3.add(Arrays.asList("a", "b", "c", "b", "a"));
        expected3.add(Arrays.asList("a", "bcb", "a"));
        expected3.add(Arrays.asList("abcba"));
        List<List<String>> result3 = solution.partition(s3);
        System.out.println("Test case 3: " + (result3.equals(expected3) ? "Passed" : "Failed"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            dfs(s, 0, res, new ArrayDeque<String>());
            return res;
        }

        private void dfs(String s, int start, List<List<String>> res, Deque<String> path) {
            if (start == s.length()) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = start; i < s.length(); i++) {
                String substring = s.substring(start, i + 1);
                if (isValid(substring)) {
                    path.addLast(substring);
                    dfs(s, i + 1, res, path);
                    path.removeLast();
                }
            }
        }

        private boolean isValid(String s) {
            int left = 0, right = s.length() - 1;
            while (left <= right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
