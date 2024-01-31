// 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
// k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
//
// 你返回所有和为 0 且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
//
//
// 示例 1：
//
//
// 输入：nums = [-1,0,1,2,-1,-4]
// 输出：[[-1,-1,2],[-1,0,1]]
// 解释：
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
// 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
// 注意，输出的顺序和三元组的顺序并不重要。
//
//
// 示例 2：
//
//
// 输入：nums = [0,1,1]
// 输出：[]
// 解释：唯一可能的三元组和不为 0 。
//
//
// 示例 3：
//
//
// 输入：nums = [0,0,0]
// 输出：[[0,0,0]]
// 解释：唯一可能的三元组和为 0 。
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 3000
// -10⁵ <= nums[i] <= 10⁵
//
//
// Related Topics 数组 双指针 排序 👍 6668 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) {
                return List.of();
            }
            Arrays.sort(nums);
            if (nums[0] > 0) {
                return List.of();
            } else if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) {
                return List.of(List.of(0, 0, 0));
            }
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[i] + nums[left] + nums[right] < 0) {
                        left++;
                    } else if (nums[i] + nums[left] + nums[right] > 0) {
                        right--;
                    }
                }
            }
            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
