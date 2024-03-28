// 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
//
//
// 示例 1:
//
//
// 输入: nums = [1,1,1,2,2,3], k = 2
// 输出: [1,2]
//
//
// 示例 2:
//
//
// 输入: nums = [1], k = 1
// 输出: [1]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// k 的取值范围是 [1, 数组中不相同的元素的个数]
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
//
//
//
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1805 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();

        // Test case 1
        int[] result1 = solution.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2);
        int[] expected1 = new int[] {1, 2};
        Arrays.sort(result1);
        Arrays.sort(expected1);
        System.out.println(Arrays.equals(result1, expected1) ? "Test case 1 passed" : "Test case 1 failed");

        // Test case 2
        int[] result2 = solution.topKFrequent(new int[] {1}, 1);
        int[] expected2 = new int[] {1};
        System.out.println(Arrays.equals(result2, expected2) ? "Test case 2 passed" : "Test case 2 failed");

        // Test case 3
        int[] result3 = solution.topKFrequent(new int[] {4, 1, -1, 2, -1, 2, 3}, 2);
        int[] expected3 = new int[] {-1, 2};
        Arrays.sort(result3);
        Arrays.sort(expected3);
        System.out.println(Arrays.equals(result3, expected3) ? "Test case 3 passed" : "Test case 3 failed");
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return hashMap.get(o1) - hashMap.get(o2);
                }
            });
            for (int num : nums) {
                hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            }
            for (Integer i : hashMap.keySet()) {
                if (queue.size() < k) {
                    queue.add(i);
                } else if (hashMap.get(queue.peek()) < hashMap.get(i)) {
                    queue.poll();
                    queue.add(i);
                }
            }
            int[] res = new int[k];
            int idx = 0;
            while (!queue.isEmpty()) {
                res[idx] = queue.poll();
                idx++;
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
