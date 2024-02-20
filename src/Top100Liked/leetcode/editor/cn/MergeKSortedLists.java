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
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2763 👎 0


package Top100Liked.leetcode.editor.cn;

/**
 * @author taowong
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        int[][] data = {{2}, {}, {-1}};
        ListNode[] lists = new ListNode[data.length];
        for (int i = 0; i < data.length; i++) {
            lists[i] = createLinkedList(data[i]);
        }
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode res = solution.mergeKLists(lists);
        ListNode node = res;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode createLinkedList(int[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        ListNode head = new ListNode(data[0]);
        ListNode current = head;
        for (int i = 1; i < data.length; i++) {
            current.next = new ListNode(data[i]);
            current = current.next;
        }
        return head;
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (null == lists || lists.length == 0) {
                return null;
            }
            ListNode head = new ListNode(0), tail = head;
            ;
            for (ListNode list : lists) {
                if (null != list) {
                    tail.next = mergeTwoLists(tail.next, list);
                }
            }
            return head.next;
        }

        private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode preHead = new ListNode(-1), prev = preHead;
            while (null != list1 && null != list2) {
                if (list1.val >= list2.val) {
                    prev.next = list2;
                    list2 = list2.next;
                } else {
                    prev.next = list1;
                    list1 = list1.next;
                }
                prev = prev.next;
            }
            if (list1 != null) {
                prev.next = list1;
            }
            if (null != list2) {
                prev.next = list2;
            }
            return preHead.next;
        }

    }


    //leetcode submit region end(Prohibit modification and deletion)

}

