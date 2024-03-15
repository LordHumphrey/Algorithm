//
// 请你设计并实现一个满足
// LRU (最近最少使用) 缓存 约束的数据结构。
//
//
//
// 实现
// LRUCache 类：
//
//
//
//
//
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组
// key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
//
//
//
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
//
//
//
// 示例：
//
//
// 输入
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// 输出
// [null, null, null, 1, null, -1, null, -1, 3, 4]
//
// 解释
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // 缓存是 {1=1}
// lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
// lRUCache.get(1);    // 返回 1
// lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
// lRUCache.get(2);    // 返回 -1 (未找到)
// lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
// lRUCache.get(1);    // 返回 -1 (未找到)
// lRUCache.get(3);    // 返回 3
// lRUCache.get(4);    // 返回 4
//
//
//
//
// 提示：
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 10000
// 0 <= value <= 10⁵
// 最多调用 2 * 10⁵ 次 get 和 put
//
//
// Related Topics 设计 哈希表 链表 双向链表 👍 3079 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.*;

/**
 * @author taowong
 */
public class LruCache {
    public static void main(String[] args) {
        List<Testcase> testcases = new ArrayList<>();
        testcases.add(new Testcase(
                new String[] {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"},
                new int[][] {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}},
                new Integer[] {null, null, null, 1, null, -1, null, -1, 3, 4}));
        testcases.add(new Testcase(
                new String[] {"LRUCache", "put", "put", "put", "put", "get", "get"},
                new int[][] {{2}, {2, 1}, {1, 1}, {2, 3}, {4, 1}, {1}, {2}},
                new Integer[] {null, null, null, null, null, -1, 3}));
        for (Testcase testcase : testcases) {
            LruCache.LRUCache lruCache = null;
            List<Integer> results = new ArrayList<>();

            for (int i = 0; i < testcase.operations.length; i++) {
                switch (testcase.operations[i]) {
                    case "LRUCache":
                        lruCache = new LruCache().new LRUCache(testcase.parameters[i][0]);
                        results.add(null);
                        break;
                    case "put":
                        lruCache.put(testcase.parameters[i][0], testcase.parameters[i][1]);
                        results.add(null);
                        break;
                    case "get":
                        results.add(lruCache.get(testcase.parameters[i][0]));
                        break;
                }
            }

            for (int i = 0; i < results.size(); i++) {
                if (!Objects.equals(results.get(i), testcase.expectedOutput[i])) {
                    System.out.println("Discrepancy found at index " + i + ": got " + results.get(i) + ", expected "
                            + testcase.expectedOutput[i]);
                }
            }
        }
    }

    static class Testcase {
        String[] operations;
        int[][] parameters;
        Integer[] expectedOutput;

        Testcase(String[] operations, int[][] parameters, Integer[] expectedOutput) {
            this.operations = operations;
            this.parameters = parameters;
            this.expectedOutput = expectedOutput;
        }
    }

    class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return super.size() > capacity;
        }
    }
}
