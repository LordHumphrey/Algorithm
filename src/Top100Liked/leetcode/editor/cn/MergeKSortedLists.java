//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2802 👎 0


package Top100Liked.leetcode.editor.cn;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();

        // Test case 1
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));
        ListNode[] lists1 = {list1, list2, list3};
        ListNode expected1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, new ListNode(6))))))));
        ListNode result1 = solution.mergeKLists(lists1);
        System.out.println("Test case 1: " + (equals(result1, expected1) ? "Passed" : "Failed"));

        // Test case 2
        ListNode[] lists2 = {};
        ListNode expected2 = null;
        ListNode result2 = solution.mergeKLists(lists2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test case 3
        ListNode[] lists3 = {null};
        ListNode expected3 = null;
        ListNode result3 = solution.mergeKLists(lists3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));
    }

    // Helper method to compare two linked lists
    public static boolean equals(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (null == lists || lists.length == 0) {
                return null;
            }
            return mergeKListsDfs(lists, 0, lists.length);
        }

        private ListNode mergeKListsDfs(ListNode[] lists, int start, int end) {
            int len = end - start, mid = start + len / 2;
            if (len <= 0) {
                return null;
            }
            if (len == 1) {
                return lists[start];
            }
            ListNode left = mergeKListsDfs(lists, start, mid);
            ListNode right = mergeKListsDfs(lists, mid, end);
            return merge2Lists(left, right);
        }

        private ListNode merge2Lists(ListNode list1, ListNode list2) {
            ListNode node1 = list1, node2 = list2, res = new ListNode(), dummy = res;
            while (node1 != null && node2 != null) {
                if (node1.val < node2.val) {
                    dummy.next = node1;
                    node1 = node1.next;
                } else {
                    dummy.next = node2;
                    node2 = node2.next;
                }
                dummy = dummy.next;
            }
            if (node1 != null) {
                dummy.next = node1;
            }
            if (node2 != null) {
                dummy.next = node2;
            }

            return res.next;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}