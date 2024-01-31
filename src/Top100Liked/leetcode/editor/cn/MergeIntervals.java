//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2225 👎 0


package Top100Liked.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            int len = intervals.length;
            if (0 == len) {
                return intervals;
            } else if (1 == len) {
                return intervals;
            }
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            List<int[]> res = new ArrayList<>();
            res.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] curIntervals = intervals[i], lastIntervals = res.getLast();
                if (curIntervals[0] > lastIntervals[1]) {
                    res.add(intervals[i]);
                } else {
                    lastIntervals[1] = Math.max(curIntervals[1], lastIntervals[1]);
                }

            }
            return res.toArray(int[][]::new);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}