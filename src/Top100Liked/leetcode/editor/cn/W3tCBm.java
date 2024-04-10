// 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
//
//
//
// 示例 1:
//
//
// 输入: n = 2
// 输出: [0,1,1]
// 解释:
// 0 --> 0
// 1 --> 1
// 2 --> 10
//
//
// 示例 2:
//
//
// 输入: n = 5
// 输出: [0,1,1,2,1,2]
// 解释:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// 3 --> 11
// 4 --> 100
// 5 --> 101
//
//
//
//
// 说明 :
//
//
// 0 <= n <= 10⁵
//
//
//
//
// 进阶:
//
//
// 给出时间复杂度为 O(n*sizeof(integer)) 的解答非常容易。但你可以在线性时间 O(n) 内用一趟扫描做到吗？
// 要求算法的空间复杂度为 O(n) 。
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount ）来执行此操作。
//
//
//
//
//
// 注意：本题与主站 338 题相同：https://leetcode-cn.com/problems/counting-bits/
//
// Related Topics 位运算 动态规划 👍 152 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.Arrays;

public class W3tCBm {
    public static void main(String[] args) {
        Solution solution = new W3tCBm().new Solution();

        // Test case 1
        int[] result1 = solution.countBits(2);
        int[] expected1 = new int[]{0, 1, 1};
        System.out.println(Arrays.equals(result1, expected1) ? "Test case 1 passed" : "Test case 1 failed");

        // Test case 2
        int[] result2 = solution.countBits(5);
        int[] expected2 = new int[]{0, 1, 1, 2, 1, 2};
        System.out.println(Arrays.equals(result2, expected2) ? "Test case 2 passed" : "Test case 2 failed");

        // Test case 3
        int[] result3 = solution.countBits(0);
        int[] expected3 = new int[]{0};
        System.out.println(Arrays.equals(result3, expected3) ? "Test case 3 passed" : "Test case 3 failed");

        // Test case 4
        int[] result4 = solution.countBits(1);
        int[] expected4 = new int[]{0, 1};
        System.out.println(Arrays.equals(result4, expected4) ? "Test case 4 passed" : "Test case 4 failed");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];

            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
