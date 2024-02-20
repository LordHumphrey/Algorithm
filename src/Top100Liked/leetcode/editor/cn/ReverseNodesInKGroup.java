//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2278 👎 0


package Top100Liked.leetcode.editor.cn;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k <= 0) {
                return head;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode p = dummy;
            int n = k;
            //增加一个哨兵节点，之后不断遍历链表
            while (p.next != null) {
                ListNode tmp = p;
                //遍历得到k个长度的链表
                while (tmp != null && tmp.next != null && n > 0) {
                    tmp = tmp.next;
                    --n;
                }
                //如果k==0说明符合条件，就反转这一组链表
                //反转之前需要将下一个节点保存，并设置next为空，防止循环指向
                //假设链表为1->2->3->4，下面的nextNode就是4，tail是1
                if (n == 0) {
                    ListNode nextNode = tmp.next;
                    ListNode tail = p.next;
                    tmp.next = null;
                    p.next = reverse(tail);
                    tail.next = nextNode;
                    p = tail;
                    n = k;
                    //如果遍历后的链表长度不是k，则不满足反转条件
                } else {
                    break;
                }
            }
            return dummy.next;
        }

        //反转单个链表
        private ListNode reverse(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
