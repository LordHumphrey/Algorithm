//给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。 
//
// 
//
// 注意： 
//
// 
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 2³¹−1]。本题中，如果除法结果溢出，则返回 231 − 1 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 15, b = 2
//输出：7
//解释：15/2 = truncate(7.5) = 7
// 
//
// 示例 2： 
//
// 
//输入：a = 7, b = -3
//输出：-2
//解释：7/-3 = truncate(-2.33333..) = -2 
//
// 示例 3： 
//
// 
//输入：a = 0, b = 1
//输出：0 
//
// 示例 4： 
//
// 
//输入：a = 1, b = 1
//输出：1 
//
// 
//
// 提示: 
//
// 
// -2³¹ <= a, b <= 2³¹ - 1 
// b != 0 
// 
//
// 
//
// 注意：本题与主站 29 题相同：https://leetcode-cn.com/problems/divide-two-integers/ 
//
// 
//
// Related Topics 数学 👍 289 👎 0


package Top100Liked.leetcode.editor.cn;

public class Xoh6Oh {
    public static void main(String[] args) {
        Solution solution = new Xoh6Oh().new Solution();

        // Test case 1: Two positive numbers
        System.out.println("Test case 1: " + (solution.divide(15, 2) == 7 ? "Passed" : "Failed"));

        // Test case 2: Two negative numbers
        System.out.println("Test case 2: " + (solution.divide(-15, -3) == 5 ? "Passed" : "Failed"));

        // Test case 3: Positive number divided by negative number
        System.out.println("Test case 3: " + (solution.divide(15, -3) == -5 ? "Passed" : "Failed"));

        // Test case 4: Divisor is 1
        System.out.println("Test case 4: " + (solution.divide(15, 1) == 15 ? "Passed" : "Failed"));

        // Test case 5: Dividend is 0
        System.out.println("Test case 5: " + (solution.divide(0, 1) == 0 ? "Passed" : "Failed"));

        // Test case 6: Result overflow
        System.out.println("Test case 6: " + (solution.divide(Integer.MIN_VALUE, -1) == Integer.MAX_VALUE ? "Passed" : "Failed"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int a, int b) {

            return 1;
        }

        private int divideCore(int dividend, int divisor) {
            int result = 0;

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}