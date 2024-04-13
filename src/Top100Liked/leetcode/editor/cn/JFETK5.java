// 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
//
// 输入: a = "11", b = "10"
// 输出: "101"
//
// 示例 2:
//
//
// 输入: a = "1010", b = "1011"
// 输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
//
//
//
//
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/
//
// Related Topics 位运算 数学 字符串 模拟 👍 85 👎 0

package Top100Liked.leetcode.editor.cn;

public class JFETK5 {
    public static void main(String[] args) {
        Solution solution = new JFETK5().new Solution();

        // Test case 1
        String a1 = "11", b1 = "1";
        String expected1 = "100";
        String result1 = solution.addBinary(a1, b1);
        System.out.println("Test case 1: " + (expected1.equals(result1) ? "Passed" : "Failed"));

        // Test case 2
        String a2 = "1010", b2 = "1011";
        String expected2 = "10101";
        String result2 = solution.addBinary(a2, b2);
        System.out.println("Test case 2: " + (expected2.equals(result2) ? "Passed" : "Failed"));

        // Test case 3
        String a3 = "0", b3 = "0";
        String expected3 = "0";
        String result3 = solution.addBinary(a3, b3);
        System.out.println("Test case 3: " + (expected3.equals(result3) ? "Passed" : "Failed"));

        // Test case 4
        String a4 = "1", b4 = "0";
        String expected4 = "1";
        String result4 = solution.addBinary(a4, b4);
        System.out.println("Test case 4: " + (expected4.equals(result4) ? "Passed" : "Failed"));

        // Test case 5
        String a5 = "1111", b5 = "1111";
        String expected5 = "11110";
        String result5 = solution.addBinary(a5, b5);
        System.out.println("Test case 5: " + (expected5.equals(result5) ? "Passed" : "Failed"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int aLen = a.length() - 1;
            int bLen = b.length() - 1;
            StringBuilder stringBuilder = new StringBuilder();
            int carry = 0;
            while (aLen >= 0 || bLen >= 0) {
                int x = aLen >= 0 ? a.charAt(aLen) - '0' : 0;
                int y = bLen >= 0 ? b.charAt(bLen) - '0' : 0;
                int sum = x + y + carry;
                carry = sum / 2;
                stringBuilder.append(sum % 2);
                aLen--;
                bLen--;
            }
            if (carry == 1) {
                stringBuilder.append(carry);
            }
            return stringBuilder.reverse().toString();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
