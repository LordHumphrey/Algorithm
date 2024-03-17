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
// Related Topics 栈 数组 单调栈 👍 1712 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    public static void main(String[] args) {
        // 创建Solution类的实例
        Solution solution = new DailyTemperatures().new Solution();

        // 创建测试用例
        int[] test1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] test2 = {30, 40, 50, 60};
        int[] test3 = {30, 60, 90};

        // 调用dailyTemperatures方法并打印结果
        System.out.println(Arrays.toString(solution.dailyTemperatures(test1))); // Expected output: [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(solution.dailyTemperatures(test2))); // Expected output: [1,1,1,0]
        System.out.println(Arrays.toString(solution.dailyTemperatures(test3))); // Expected output: [1,1,0]
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int len = temperatures.length;
            if (len == 0) {
                return new int[0];
            }
            int[] ans = new int[len];
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < temperatures.length; i++) {
                int temperature = temperatures[i];
                while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                    int idx = stack.pop();
                    ans[idx] = i - idx;
                }
                stack.push(i);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
