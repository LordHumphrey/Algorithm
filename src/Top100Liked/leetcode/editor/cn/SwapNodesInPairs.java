//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 2194 👎 0


package Top100Liked.leetcode.editor.cn;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();

        // 测试用例1
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode expected1 = new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(3))));
        ListNode result1 = solution.swapPairs(head1);
        System.out.println("Test case 1: " + (equals(result1, expected1) ? "Passed" : "Failed"));

        // 测试用例2
        ListNode head2 = null;
        ListNode expected2 = null;
        ListNode result2 = solution.swapPairs(head2);
        System.out.println("Test case 2: " + (equals(result2, expected2) ? "Passed" : "Failed"));

        // 测试用例3
        ListNode head3 = new ListNode(1);
        ListNode expected3 = new ListNode(1);
        ListNode result3 = solution.swapPairs(head3);
        System.out.println("Test case 3: " + (equals(result3, expected3) ? "Passed" : "Failed"));
    }

    // 辅助函数，用于比较两个链表是否相等
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
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(), pre = dummy;
            dummy.next = head;
            while (head != null && head.next != null) {
                ListNode first = head;
                ListNode second = head.next;

                pre.next = second;
                first.next = second.next;
                second.next = first;

                pre = first;
                head = first.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}