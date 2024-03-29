// 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
// 输入：l1 = [2,4,3], l2 = [5,6,4]
// 输出：[7,0,8]
// 解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
// 输入：l1 = [0], l2 = [0]
// 输出：[0]
//
//
// 示例 3：
//
//
// 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// 输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Top100Liked.leetcode.editor.cn.Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
//
// Related Topics 递归 链表 数学 👍 10485 👎 0

package Top100Liked.leetcode.editor.cn;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();

        // Test case 1
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result1 = solution.addTwoNumbers(l1, l2);
        System.out.println(
                (result1.val == 7 && result1.next.val == 0 && result1.next.next.val == 8)
                        ? "Test case 1 passed"
                        : "Test case 1 failed");

        // Test case 2
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        ListNode result2 = solution.addTwoNumbers(l3, l4);
        System.out.println((result2.val == 0) ? "Test case 2 passed" : "Test case 2 failed");

        // Test case 3
        ListNode l5 = new ListNode(
                9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l6 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode result3 = solution.addTwoNumbers(l5, l6);
        System.out.println(
                (result3.val == 8
                                && result3.next.val == 9
                                && result3.next.next.val == 9
                                && result3.next.next.next.val == 9
                                && result3.next.next.next.next.val == 0
                                && result3.next.next.next.next.next.val == 0
                                && result3.next.next.next.next.next.next.val == 0
                                && result3.next.next.next.next.next.next.next.val == 1)
                        ? "Test case 3 passed"
                        : "Test case 3 failed");
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode r1 = l1, r2 = l2, dummyNode = new ListNode(0), cur = dummyNode;
            int carry = 0;
            while (r1 != null || r2 != null) {
                int x = r1 == null ? 0 : r1.val;
                int y = r2 == null ? 0 : r2.val;
                int sum = x + y + carry;
                carry = sum / 10;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
                if (r1 != null) {
                    r1 = r1.next;
                }
                if (r2 != null) {
                    r2 = r2.next;
                }
            }
            if (carry > 0) {
                cur.next = new ListNode(carry);
            }
            return dummyNode.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
