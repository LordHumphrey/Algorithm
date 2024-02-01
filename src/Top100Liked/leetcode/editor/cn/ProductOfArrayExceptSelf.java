//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。） 
//
// Related Topics 数组 前缀和 👍 1697 👎 0


package Top100Liked.leetcode.editor.cn;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            if (0 == len) {
                return new int[0];
            } else if (1 == len) {
                return nums;
            } else if (2 == len) {
                return new int[]{nums[1], nums[0]};
            }
            int[] forwardArr = new int[len], backwardArr = new int[len], res = new int[len];
            forwardArr[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                forwardArr[i] = forwardArr[i - 1] * nums[i];
            }
            backwardArr[len - 1] = nums[len - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                backwardArr[i] = backwardArr[i + 1] * nums[i];
            }
            res[0] = backwardArr[1];
            res[len - 1] = forwardArr[len - 1 - 1];
            for (int i = 1; i < len - 1; i++) {
                res[i] = forwardArr[i - 1] * backwardArr[i + 1];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}