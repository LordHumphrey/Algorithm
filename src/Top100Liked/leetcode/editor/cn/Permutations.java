//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2867 👎 0


package Top100Liked.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();

        // 测试用例1
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> expected1 = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2), Arrays.asList(2, 1, 3), Arrays.asList(2, 3, 1), Arrays.asList(3, 1, 2), Arrays.asList(3, 2, 1));
        List<List<Integer>> result1 = solution.permute(nums1);
        System.out.println("Test case 1: " + (result1.equals(expected1) ? "Passed" : "Failed"));

        // 测试用例2
        int[] nums2 = {0, 1};
        List<List<Integer>> expected2 = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 0));
        List<List<Integer>> result2 = solution.permute(nums2);
        System.out.println("Test case 2: " + (result2.equals(expected2) ? "Passed" : "Failed"));

        // 测试用例3
        int[] nums3 = {1};
        List<List<Integer>> expected3 = Collections.singletonList(Collections.singletonList(1));
        List<List<Integer>> result3 = solution.permute(nums3);
        System.out.println("Test case 3: " + (result3.equals(expected3) ? "Passed" : "Failed"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}