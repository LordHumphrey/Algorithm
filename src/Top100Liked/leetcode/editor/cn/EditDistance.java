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

        // Test case 1
        String word11 = "horse";
        String word12 = "ros";
        int expected1 = 3;
        int result1 = solution.minDistance(word11, word12);
        System.out.println("1-" + (expected1 == result1 ? "通过" : "未通过") + "-word1: horse, word2: ros");

        // Test case 2
        String word21 = "intention";
        String word22 = "execution";
        int expected2 = 5;
        int result2 = solution.minDistance(word21, word22);
        System.out.println("2-" + (expected2 == result2 ? "通过" : "未通过") + "-word1: intention, word2: execution");

        // Test case 3: No changes needed
        String word31 = "test";
        String word32 = "test";
        int expected3 = 0;
        int result3 = solution.minDistance(word31, word32);
        System.out.println("3-" + (expected3 == result3 ? "通过" : "未通过") + "-word1: test, word2: test");

        // Test case 4: One character needs to be replaced
        String word41 = "test";
        String word42 = "best";
        int expected4 = 1;
        int result4 = solution.minDistance(word41, word42);
        System.out.println("4-" + (expected4 == result4 ? "通过" : "未通过") + "-word1: test, word2: best");

        // Additional Test case 7: Empty string to non-empty string
        String word71 = "";
        String word72 = "a";
        int expected7 = 1;
        int result7 = solution.minDistance(word71, word72);
        System.out.println("7-" + (expected7 == result7 ? "通过" : "未通过") + "-word1: \"\", word2: \"a\"");

        // Additional Test case 8: Different strings
        String word81 = "distance";
        String word82 = "springbok";
        int expected8 = 9;
        int result8 = solution.minDistance(word81, word82);
        System.out.println("8-" + (expected8 == result8 ? "通过" : "未通过") + "-word1: distance, word2: springbok");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}