//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 请你实现时间复杂度为 
//O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics 数组 哈希表 👍 2049 👎 0


package Top100Liked.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(solution.firstMissingPositive(new int[]{2147483647}));
        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 3, 10, 2147483647, 9}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int len = nums.length;
            if (0 == len) {
                return 1;
            }
            Map<Integer, Integer> hashMap = new HashMap<>();
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int num : nums) {
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
                hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            }
            int i = 1, j = 0;
            if (max + 2 <= 0) {
                j = Integer.MAX_VALUE;
            } else {
                j = max + 2;
            }
            for (; i <= j; i++) {
                if (!hashMap.containsKey(i)) {
                    return i;
                }

            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}