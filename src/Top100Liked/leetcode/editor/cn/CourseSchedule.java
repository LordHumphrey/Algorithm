//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1925 👎 0


package Top100Liked.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();

        // Test case 1: No prerequisites
        int numCourses1 = 2;
        int[][] prerequisites1 = {};
        boolean result1 = solution.canFinish(numCourses1, prerequisites1);
        System.out.println(result1 ? "Test case 1 passed" : "Test case 1 failed");

        // Test case 2: One course has prerequisites
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}};
        boolean result2 = solution.canFinish(numCourses2, prerequisites2);
        System.out.println(result2 ? "Test case 2 passed" : "Test case 2 failed");

        // Test case 3: Multiple courses have prerequisites
        int numCourses3 = 3;
        int[][] prerequisites3 = {{1, 0}, {2, 1}};
        boolean result3 = solution.canFinish(numCourses3, prerequisites3);
        System.out.println(result3 ? "Test case 3 passed" : "Test case 3 failed");

        // Test case 4: There is a cycle
        int numCourses4 = 2;
        int[][] prerequisites4 = {{1, 0}, {0, 1}};
        boolean result4 = solution.canFinish(numCourses4, prerequisites4);
        System.out.println(!result4 ? "Test case 4 passed" : "Test case 4 failed");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int length = prerequisites.length;
            int[] inDegree = new int[numCourses];
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adj.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                inDegree[prerequisite[0]]++;
                adj.get(prerequisite[1]).add(prerequisite[0]);
            }
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.addLast(i);
                }
            }
            while (!queue.isEmpty()) {
                int first = queue.removeFirst();
                numCourses--;
                for (Integer i : adj.get(first)) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        queue.addLast(i);
                    }
                }
            }
            return numCourses == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}