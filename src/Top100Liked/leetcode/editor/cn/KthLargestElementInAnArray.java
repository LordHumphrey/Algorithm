//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2442 👎 0


package Top100Liked.leetcode.editor.cn;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();

        // Test case 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        int expected1 = 5;
        testFindKthLargest(solution, nums1, k1, expected1);

        // Test case 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        int expected2 = 4;
        testFindKthLargest(solution, nums2, k2, expected2);

        // Add more test cases as needed
    }

    public static void testFindKthLargest(Solution solution, int[] nums, int k, int expected) {
        int result = solution.findKthLargest(nums, k);
        if (result == expected) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed. Expected " + expected + " but got " + result);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
            for (int num : nums) {
                queue.add(num);
            }
            for (int i = 0; i < k - 1; i++) {
                queue.poll();
            }
            return queue.peek();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}