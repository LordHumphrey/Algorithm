// Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
// 写检查。
//
// 请你实现 Trie 类：
//
//
// Trie() 初始化前缀树对象。
// void insert(String word) 向前缀树中插入字符串 word 。
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回
// false 。
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
// 则，返回 false 。
//
//
//
//
// 示例：
//
//
// 输入
// ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
// [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
// 输出
// [null, null, true, false, true, null, true]
//
// 解释
// Trie trie = new Trie();
// trie.insert("apple");
// trie.search("apple");   // 返回 True
// trie.search("app");     // 返回 False
// trie.startsWith("app"); // 返回 True
// trie.insert("app");
// trie.search("app");     // 返回 True
//
//
//
//
// 提示：
//
//
// 1 <= word.length, prefix.length <= 2000
// word 和 prefix 仅由小写英文字母组成
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次
//
//
// Related Topics 设计 字典树 哈希表 字符串 👍 1604 👎 0

package Top100Liked.leetcode.editor.cn;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new ImplementTriePrefixTree().new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // 应该输出true
        System.out.println(trie.search("app")); // 应该输出false
        System.out.println(trie.startsWith("app")); // 应该输出true
        trie.insert("app");
        System.out.println(trie.search("app")); // 应该输出true
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    class Trie {

        class TrieNode {
            boolean isEnd = false;
            TrieNode[] children = new TrieNode[26];
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode temp = this.root;
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                int j = c - 'a';
                if (temp.children[j] == null) {
                    temp.children[j] = new TrieNode();
                }
                temp = temp.children[j];
            }
            temp.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode temp = this.root;
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                int j = c - 'a';
                if (temp.children[j] == null) {
                    return false;
                }
                temp = temp.children[j];
            }
            return temp != null && temp.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode temp = this.root;
            char[] charArray = prefix.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                int j = c - 'a';
                if (temp.children[j] == null) {
                    return false;
                }
                temp = temp.children[j];
            }
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
