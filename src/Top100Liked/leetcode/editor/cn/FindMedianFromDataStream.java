//中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。 
//
// 
// 例如 arr = [2,3,4] 的中位数是 3 。 
// 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。 
// 
//
// 实现 MedianFinder 类: 
//
// 
// MedianFinder() 初始化 MedianFinder 对象。 
// void addNum(int num) 将数据流中的整数 num 添加到数据结构中。 
// double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10⁻⁵ 以内的答案将被接受。 
// 
//
// 示例 1： 
//
// 
//输入
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//输出
//[null, null, null, 1.5, null, 2.0]
//
//解释
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0 
//
// 提示: 
//
// 
// -10⁵ <= num <= 10⁵ 
// 在调用 findMedian 之前，数据结构中至少有一个元素 
// 最多 5 * 10⁴ 次调用 addNum 和 findMedian 
// 
//
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 1044 👎 0


package Top100Liked.leetcode.editor.cn;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        FindMedianFromDataStream outer = new FindMedianFromDataStream();
        MedianFinder medianFinder = outer.new MedianFinder();

        // Test case 1
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Test case 1: " + (Math.abs(medianFinder.findMedian() - 1.5) < 1e-5 ? "Passed" : "Failed"));

        // Test case 2
        medianFinder.addNum(3);
        System.out.println("Test case 2: " + (Math.abs(medianFinder.findMedian() - 2.0) < 1e-5 ? "Passed" : "Failed"));

        // Additional test cases
        medianFinder.addNum(4);
        System.out.println("Test case 3: " + (Math.abs(medianFinder.findMedian() - 2.5) < 1e-5 ? "Passed" : "Failed"));

        medianFinder.addNum(5);
        System.out.println("Test case 4: " + (Math.abs(medianFinder.findMedian() - 3.0) < 1e-5 ? "Passed" : "Failed"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;


        public MedianFinder() {

        }

        public void addNum(int num) {

        }


        public double findMedian() {
            return 0.1;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}