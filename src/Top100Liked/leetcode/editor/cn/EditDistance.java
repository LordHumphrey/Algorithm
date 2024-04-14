//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 3363 👎 0


package Top100Liked.leetcode.editor.cn;

public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();

        // Test case 1: No changes needed
        String word11 = "test";
        String word12 = "test";
        int result1 = solution.minDistance(word11, word12);
        System.out.println(result1 == 0 ? "Test case 1 passed" : "Test case 1 failed");

        // Test case 2: One character needs to be replaced
        String word21 = "test";
        String word22 = "best";
        int result2 = solution.minDistance(word21, word22);
        System.out.println(result2 == 1 ? "Test case 2 passed" : "Test case 2 failed");

        // Test case 3: One character needs to be inserted
        String word31 = "test";
        String word32 = "tests";
        int result3 = solution.minDistance(word31, word32);
        System.out.println(result3 == 1 ? "Test case 3 passed" : "Test case 3 failed");

        // Test case 4: One character needs to be deleted
        String word41 = "tests";
        String word42 = "test";
        int result4 = solution.minDistance(word41, word42);
        System.out.println(result4 == 1 ? "Test case 4 passed" : "Test case 4 failed");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}