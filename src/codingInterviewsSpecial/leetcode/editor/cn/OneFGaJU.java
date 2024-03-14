// 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且
// 不重复 的三元组。
//
//
//
// 示例 1：
//
//
// 输入：nums = [-1,0,1,2,-1,-4]
// 输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
// 输入：nums = []
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：nums = [0]
// 输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -10⁵ <= nums[i] <= 10⁵
//
//
//
//
//
// 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/
//
// Related Topics 数组 双指针 排序 👍 144 👎 0

package codingInterviewsSpecial.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneFGaJU {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testArray = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(testArray);
        System.out.println(result);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            int[] array = Arrays.stream(nums).distinct().sorted().toArray();
            int length = array.length;
            if (length < 3) {
                return List.of();
            }
            for (int i = 0; i < length; i++) {
                int start = i, end = length - 1;
                int target = -nums[i];
                while (start < length && end >= 0 && nums[start] + nums[end] != target) {
                    if (nums[start] + nums[end] > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
                if (start < length && end >= 0 && nums[start] + nums[end] == target) {
                    ans.add(List.of(nums[i], nums[start], nums[end]));
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
