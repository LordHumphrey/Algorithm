//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 1961 👎 0


package Top100Liked.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int num : nums) {
                hashSet.add(num);
            }
            int result = 0;
            for (Integer i : hashSet) {
                int cur = i;
                if (hashSet.contains(cur - 1)) {
                    continue;
                } else {
                    while (hashSet.contains(cur + 1)) {
                        cur++;
                    }
                }
                result = Math.max(result, cur - i + 1);
            }
            return result;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        public int longestConsecutive(int[] nums) {
            // key表示num，value表示num最远到达的连续右边界
            Map<Integer, Integer> map = new HashMap<>();
            // 初始化每个num的右边界为自己
            for (int num : nums) {
                map.put(num, num);
            }

            int ans = 0;
            for (int num : nums) {
                if (!map.containsKey(num - 1)) {
                    int right = map.get(num);
                    // 遍历得到最远的右边界
                    while (map.containsKey(right + 1)) {
                        right = map.get(right + 1);
                    }
                    // 更新右边界
                    map.put(num, right);
                    // 更新答案
                    ans = Math.max(ans, right - num + 1);
                }

            }
            return ans;
        }
    }

}