// 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
// 在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
//
//
// 示例 1:
//
//
// 输入: temperatures = [73,74,75,71,69,72,76,73]
// 输出: [1,1,4,2,1,1,0,0]
//
//
// 示例 2:
//
//
// 输入: temperatures = [30,40,50,60]
// 输出: [1,1,1,0]
//
//
// 示例 3:
//
//
// 输入: temperatures = [30,60,90]
// 输出: [1,1,0]
//
//
//
// 提示：
//
//
// 1 <= temperatures.length <= 10⁵
// 30 <= temperatures[i] <= 100
//
//
// Related Topics 栈 数组 单调栈 👍 1732 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();

        // Test case 1
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected1 = {1, 1, 4, 2, 1, 1, 0, 0};
        int[] result1 = solution.dailyTemperatures(temperatures1);
        System.out.println("Test case 1: " + (Arrays.equals(expected1, result1) ? "Passed" : "Failed"));

        // Test case 2
        int[] temperatures2 = {30, 40, 50, 60};
        int[] expected2 = {1, 1, 1, 0};
        int[] result2 = solution.dailyTemperatures(temperatures2);
        System.out.println("Test case 2: " + (Arrays.equals(expected2, result2) ? "Passed" : "Failed"));

        // Test case 3
        int[] temperatures3 = {30, 60, 90};
        int[] expected3 = {1, 1, 0};
        int[] result3 = solution.dailyTemperatures(temperatures3);
        System.out.println("Test case 3: " + (Arrays.equals(expected3, result3) ? "Passed" : "Failed"));
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> stack = new ArrayDeque<>();
            int length = temperatures.length;
            int[] res = new int[length];
            for (int i = 0; i < temperatures.length; i++) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    int i1 = i - stack.pop();
                    res[i] = i1;
                }
                stack.push(i);
            }

            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
