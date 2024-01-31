// 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//
// 子数组是数组中元素的连续非空序列。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,1,1], k = 2
// 输出：2
//
//
// 示例 2：
//
//
// 输入：nums = [1,2,3], k = 3
// 输出：2
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2 * 10⁴
// -1000 <= nums[i] <= 1000
// -10⁷ <= k <= 10⁷
//
//
// Related Topics 数组 哈希表 前缀和 👍 2235 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int result = 0, length = nums.length, preSum = 0;
            if (length == 0) {
                return result;
            }
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            hashMap.put(0, 1);
            for (int num : nums) {
                preSum += num;
                if (hashMap.containsKey(preSum - k)) {
                    result += hashMap.get(preSum - k);
                }
                hashMap.put(preSum, hashMap.getOrDefault(preSum, 0) + 1);
            }
            return result;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
