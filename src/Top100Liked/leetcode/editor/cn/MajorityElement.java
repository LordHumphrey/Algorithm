// 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1：
//
//
// 输入：nums = [3,2,3]
// 输出：3
//
// 示例 2：
//
//
// 输入：nums = [2,2,1,1,1,2,2]
// 输出：2
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 5 * 10⁴
// -10⁹ <= nums[i] <= 10⁹
//
//
//
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 2148 👎 0
/**
 * 由于多数超过50%, 比如100个数，那么多数至少51个，剩下少数是49个。
 *
 * 第一个到来的士兵，直接插上自己阵营的旗帜占领这块高地，此时领主 winner 就是这个阵营的人，现存兵力 count = 1。
 *
 * 如果新来的士兵和前一个士兵是同一阵营，则集合起来占领高地，领主不变，winner 依然是当前这个士兵所属阵营，现存兵力 count++；
 *
 * 如果新来到的士兵不是同一阵营，则前方阵营派一个士兵和它同归于尽。 此时前方阵营兵力count --。（即使双方都死光，这块高地的旗帜 winner 依然不变，因为已经没有活着的士兵可以去换上自己的新旗帜）
 *
 * 当下一个士兵到来，发现前方阵营已经没有兵力，新士兵就成了领主，winner 变成这个士兵所属阵营的旗帜，现存兵力 count ++。
 *
 * 就这样各路军阀一直以这种以一敌一同归于尽的方式厮杀下去，直到少数阵营都死光，那么最后剩下的几个必然属于多数阵营，winner 就是多数阵营。（多数阵营 51个，少数阵营只有49个，死剩下的2个就是多数阵营的人）
 */
package Top100Liked.leetcode.editor.cn;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        int[] testArray = {2, 2, 1, 1, 1, 2, 2};
        int result = solution.majorityElement(testArray);
        System.out.println(result); // Expected output: 2
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int win = 0, cnt = 0;
            for (int num : nums) {
                if (num == win) {
                    cnt++;
                } else if (cnt == 0) {
                    win = num;
                    cnt++;
                } else {
                    cnt--;
                }
            }
            return win;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
